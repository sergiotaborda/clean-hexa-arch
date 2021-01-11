package com.github.storage.configuration;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;

import com.github.commons.reflection.PropertyMetadata;
import com.github.commons.reflection.ReflectionException;

public class StoreDataPropertyModel {

	private final boolean isIdentifier;
	private final PropertyMetadata metaData;
	private final PropertyDescriptor descriptor;

	public StoreDataPropertyModel(PropertyMetadata metaData , boolean isIdentifier) {
		this.metaData = metaData;
		this.descriptor = BeanUtils.getPropertyDescriptor(metaData.getParentType(), metaData.getName());
		this.isIdentifier = isIdentifier;
	}

	public String getName() {
		return metaData.getName();
	}

	
	public Class<?> getPropertyType() {
		return metaData.getType();
	}


	public boolean isIdentifier() {
		return isIdentifier;
	}


	public Object readValue(Object instance) {
		try {
			return descriptor.getReadMethod().invoke(instance);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(e);
		}
	}

	
	public void writeValue(Object instance, Object value) {
		 try {
			 descriptor.getWriteMethod().invoke(instance, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ReflectionException(e);
		}
	}

}
