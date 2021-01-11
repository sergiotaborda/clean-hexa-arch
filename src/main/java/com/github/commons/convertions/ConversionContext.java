package com.github.commons.convertions;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.github.commons.sequences.Sequence;

@SuppressWarnings("rawtypes") // treat Converters as raw types
public class ConversionContext {

	private final Map<ConversionKey, Converter> converters;
	private final Class<?> requestedType;
	private final Class<?> parentType;

	public ConversionContext(Map<ConversionKey, Converter> converters, Class<?>parentType , Class<?> requestedType) {
		this.converters = converters;
		this.requestedType =requestedType;
		this.parentType = parentType;
	}
	
	public <T> ConversionContext OfType(Class<T> requestedType){
		return new ConversionContext(this.converters, this.requestedType, requestedType);
	}

	public <T> T convertTo(Class<T> type, Object source) {
		if (source == null) {
			return null;
		}
		
		Class<?> sourceType = source.getClass();
		
		if (Optional.class.isAssignableFrom(sourceType)) {
			
			var op = ((Optional)source);
			if (op.isEmpty()) {
				if (Optional.class.isAssignableFrom(type)) {
					return (T) op;
				} else {
					return null;
				}
			} else {
				if (Optional.class.isAssignableFrom(type)) {
			
					return (T)Optional.ofNullable(convertTo( type  , op.get()));
					
				} else {
					source = op.get();
				}
			}
		} 
		
		if (type.isInstance(source)) {
			return type.cast(source);
		}
		
		var converter = resolveConverter(sourceType, type);
				
		if (converter.isPresent()) {
			return converter.get().convertTo(this.OfType(type), source);
		}
		
		var entry = this.converters.entrySet().stream()
				.filter(it -> it.getKey().match(sourceType, type) || it.getKey().match(type, sourceType))
				.findAny();
		
		if(entry.isPresent()) {
			if (entry.get().getKey().match(sourceType, type)) {
				converters.put(new ConversionKey(sourceType, type), entry.get().getValue());
				converters.put(new ConversionKey(type, sourceType), entry.get().getValue().revert());
				
				return type.cast(entry.get().getValue().convertTo(this.OfType(type), source));
				
			} else if (entry.get().getKey().match(type, sourceType)) {
				converters.put(new ConversionKey(type, sourceType), entry.get().getValue());
				converters.put(new ConversionKey(sourceType,type), entry.get().getValue().revert());
				
				return type.cast(entry.get().getValue().revert().convertTo(this.OfType(type), source));
			}
			
		}
		
		
		throw new IllegalStateException("No converter exists for converting " + sourceType.getName() + " to " + type.getName());
	}

	@SuppressWarnings("unchecked") // types are compatible design
	private <T> Optional<Converter<Object,T>> resolveConverter(Class<?> sourceType, Class<T> targetType){
		
		
		Converter converter = converters.get(new ConversionKey(sourceType, targetType));
		
		if(converter == null) {
			converter = converters.get(new ConversionKey(targetType, sourceType));
			if(converter != null) {
				converter = converter.revert();
			}
		}
		
		return Optional.ofNullable(converter);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> convertAll(Class<T> type, List<?> all) {
		
		if(all == null || all.isEmpty()) {
			return Collections.emptyList();
		}
		
		Optional<?> notNull = all.stream().filter(it -> it != null).findAny();
		
		if (notNull.isPresent()) {
			return resolveConverter(notNull.get().getClass(), type)
					.orElseThrow(() -> new IllegalStateException("No converter exists for converting " + all.get(0).getClass().getName() + " to " + type.getName()))
					.convertAllTo(this,all);
		} else { //all are nulls, so type does not matter
			return (List<T>) all;
		}

	}
	
	@SuppressWarnings("unchecked")
	public <T> Sequence<T> convertAll(Class<T> type, Sequence<?> all) {
		
		if(all == null || all.isEmpty()) {
			return Sequence.empty();
		}
		
		Optional<?> notNull = all.filter(it -> it != null).findAny();
		
		if (notNull.isPresent()) {
			return resolveConverter(notNull.get().getClass(), type)
					.orElseThrow(() -> new IllegalStateException("No converter exists for converting " + all.findFirst().get().getClass().getName() + " to " + type.getName()))
					.convertAllTo(this,all);
		} else { //all are nulls, so type does not matter
			return (Sequence<T>) all;
		}

	}

	public Class<?> getRequestedType() {
		return requestedType;
	}

	public Class<?> getParentType() {
		return parentType;
	}
}
