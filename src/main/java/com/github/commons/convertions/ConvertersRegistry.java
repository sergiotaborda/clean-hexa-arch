package com.github.commons.convertions;

public interface ConvertersRegistry {

	public <S,T> ConvertersRegistry add(Converter<S,T> converter);
	
}
