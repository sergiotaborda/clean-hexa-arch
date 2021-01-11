package com.github.commons.convertions;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

import com.github.commons.reflection.Reflection;
import com.github.commons.reflection.ReflectionException;

public class PropertyMapping<S, T , P, R> {

	private final Function<S, P> sourcePropertySelector;
	private final Function<T, R> targetPropertySelector;
	private String sourcePropertyName;
	private Class<?> sourcePropertyType;
	private String targetPropertyName;
	private Class<?> targetPropertyType;

	public PropertyMapping(Class<S> sourceType, Class<T> targetType, Function<S, P> sourcePropertySelector, Function<T, R> targetPropertySelector) {
		this.sourcePropertySelector = sourcePropertySelector;
		this.targetPropertySelector = targetPropertySelector;
		
	
		var property = Reflection.obtainFromSelector(sourceType,sourcePropertySelector);
		
		this.sourcePropertyName = property.getName();
		this.sourcePropertyType = property.getType();
		

		property = Reflection.obtainFromSelector(targetType,targetPropertySelector);
		

		this.targetPropertyName = property.getName();
		this.targetPropertyType = property.getType();
			
	}


	public P getSourcePropertyValue(S source) {
		return this.sourcePropertySelector.apply(source);
	}
	
	public void setSourcePropertyValue(S source, P value) {
		try {
			source.getClass().getMethod("set" + this.sourcePropertyName, this.sourcePropertyType).invoke(source, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(e);
		}
	}
	
	public R getTargetPropertyValue(T target) {
		return this.targetPropertySelector.apply(target);
	}
	
	public void setTargetPropertyValue(T target, R value) {
		try {
			target.getClass().getMethod("set" + this.targetPropertyName, this.targetPropertyType).invoke(target, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(e);
		}
	}


	public Class<R> getTargetPropertyType() {
		return (Class<R>) this.targetPropertyType;
	}
	
	public Class<P> getSourcePropertyType() {
		return (Class<P>) this.sourcePropertyType;
	}

}

