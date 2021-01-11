package com.github.commons.convertions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.github.commons.reflection.Reflection;
import com.github.commons.reflection.ReflectionException;
import com.github.commons.sequences.Sequence;

public class ListPropertyMapping<S, T , P, R> {

	private final Function<S, List<P>> sourcePropertySelector;
	private final Function<T, List<R>> targetPropertySelector;
	private final String sourcePropertyName;
	private final Class<?> sourcePropertyType;
	private final String targetPropertyName;
	private final Class<?> targetPropertyType;
	private final Class<P> innerSouceType;
	private final Class<R> innerTargetType;

	public ListPropertyMapping(
			Class<S> sourceType, 
			Class<T> targetType,
			Function<S, List<P>> sourcePropertySelector, 
			Function<T, List<R>> targetPropertySelector, 
			Class<P> innerSouceType, 
			Class<R> innerTargetType
	) {
		this.innerSouceType = innerSouceType;
		this.innerTargetType = innerTargetType;
		
		this.sourcePropertySelector = sourcePropertySelector;
		this.targetPropertySelector = targetPropertySelector;
		

		var property = Reflection.obtainFromSelector(sourceType,sourcePropertySelector);
		
		this.sourcePropertyName = property.getName();
		this.sourcePropertyType = property.getType();
		

		property = Reflection.obtainFromSelector(targetType,targetPropertySelector);
		

		this.targetPropertyName = property.getName();
		this.targetPropertyType = property.getType();
			
	}

	
	private static Class parseType(Class propertyType, Class type, String propertyName) {
		if (!Optional.class.isAssignableFrom(propertyType)) {
			return propertyType;
		}
		
		var setter = "set" + propertyName;
		
		return Sequence.of(type.getMethods()).filter(m -> m.getName().equals(setter)).findAny()
		.map(m -> m.getParameters()[0].getType())
		.orElseThrow(() -> new IllegalStateException(propertyName + " is not modifable"));
	}


	private static String parseName(String methodName) {
		if (methodName.startsWith("get")) {
			return methodName.substring(3);
		} else if (methodName.startsWith("is")) {
			return methodName.substring(2);
		} 
		throw new IllegalStateException("Cannot map a non property method");
	}


	public List<P> getSourcePropertyValue(S source) {
		return this.sourcePropertySelector.apply(source);
	}
	
	public void setSourcePropertyValue(S source, List<P> value) {
		try {
			source.getClass().getMethod("set" + this.sourcePropertyName, this.sourcePropertyType).invoke(source, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(e);
		}
	}
	
	public List<R> getTargetPropertyValue(T target) {
		return this.targetPropertySelector.apply(target);
	}
	
	public void setTargetPropertyValue(T target, List<R> value) {
		try {
			target.getClass().getMethod("set" + this.targetPropertyName, this.targetPropertyType).invoke(target, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(e);
		}
	}


	public Class<R> getTargetPropertyType() {
		return (Class<R>) this.innerTargetType;
	}
	
	public Class<P> getSourcePropertyType() {
		return (Class<P>) this.innerSouceType;
	}

}

