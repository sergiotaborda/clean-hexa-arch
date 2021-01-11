package com.github.commons.convertions;

import java.lang.reflect.ParameterizedType;

import com.github.commons.reflection.Reflection;

public abstract class AbstractConverter<S, T> implements Converter<S,T> {

	
	private Class<S> sourceType;
	private Class<T> targetType;

	protected AbstractConverter() {
		var typeArguments = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
	    this.sourceType = (Class<S>) typeArguments[0];
		this.targetType = (Class<T>) typeArguments[1];
	}
	
	@Override
	public final Class<S> getSourceType() {
		return sourceType;
	}

	@Override
	public final Class<T> getTargetType() {
		return targetType;
	}

	protected T newTargetInstance() {
		return Reflection.newInstance(targetType);
	}
	
	protected S newSourceInstance() {
		return Reflection.newInstance(sourceType);
	}
}
