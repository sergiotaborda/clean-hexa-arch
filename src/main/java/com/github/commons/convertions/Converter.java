package com.github.commons.convertions;

import java.util.List;
import java.util.stream.Collectors;

import com.github.commons.sequences.Sequence;

public interface Converter<S,T> {

	public Class<S> getSourceType();
	public Class<T> getTargetType();
	
	public T convertTo(ConversionContext context, S source);
	public S convertFrom(ConversionContext context,T target);
	
	
	public default List<T> convertAllTo(ConversionContext context,List<? extends S> all){
		return all.stream().map(it -> convertTo(context, it)).collect(Collectors.toList());
	}
	
	public default Sequence<T> convertAllTo(ConversionContext context,Sequence<? extends S> all){
		return all.map(it -> convertTo(context, it));
	}
	
	
	public default List<S> convertAllFrom(ConversionContext context,List<? extends T> all) {
		return all.stream().map(it -> convertFrom(context, it)).collect(Collectors.toList());
	}

	public default Converter<T,S> revert(){
		return new ReverseConverter<T,S>(this);
	}
}
