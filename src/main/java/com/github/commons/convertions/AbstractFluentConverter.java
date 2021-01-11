package com.github.commons.convertions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class AbstractFluentConverter<S, T> extends AbstractConverter<S, T>{

	
	List<PropertyMapping> mappings = new ArrayList<>();
	List<ListPropertyMapping> listMappings = new ArrayList<>();
	
	protected <P> SourcePropertyMapper<S,T,P> map(Function<S,P> propertySelector) {
		return new SourcePropertyMapper<S,T,P>(this, propertySelector);
	}
	
	protected <P> SourceListPropertyMapper<S,T,P> mapList(Function<S,List<P>> propertySelector) {
		return new SourceListPropertyMapper<S,T,P>(this, propertySelector);
	}
	
	<P,R> void  add(PropertyMapping<S, T, P, R> propertyMapping) {
		mappings.add(propertyMapping);
	}
	
	<P,R> void  add(ListPropertyMapping<S, T, P, R> propertyMapping) {
		listMappings.add(propertyMapping);
	}
	
	@Override
	public T convertTo(ConversionContext context, S source) {
		
		if (source == null) {
			return null;
		}
		
		var target = this.newTargetInstance();
		
		for (var p : mappings) {
			var value = p.getSourcePropertyValue(source);
			
			var convertedValue = context.convertTo(p.getTargetPropertyType(), value);
			
			p.setTargetPropertyValue(target, convertedValue);
		}
		
		for (var p : listMappings) {
			var value = p.getSourcePropertyValue(source);
			
			var convertedValue = context.convertAll(p.getTargetPropertyType(), value);
			
			p.setTargetPropertyValue(target, convertedValue);
		}
		
		
		return target;
		
	}

	@Override
	public S convertFrom(ConversionContext context, T target) {
		if (target == null) {
			return null;
		}
		
		var source = this.newSourceInstance();
		
		for (var p : mappings) {
			var value = p.getTargetPropertyValue(target);
			
			var convertedValue = context.convertTo(p.getSourcePropertyType(), value);
			
			p.setSourcePropertyValue(source, convertedValue);
		}
		
		for (var p : listMappings) {
			var value = p.getTargetPropertyValue(target);
			
			var convertedValue = context.convertAll(p.getSourcePropertyType(), value);
			
			p.setSourcePropertyValue(source, convertedValue);
		}
		
		return source;
	}



}
