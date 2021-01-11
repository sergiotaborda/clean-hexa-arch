package com.github.commons.reflection;

public class PropertyMetadata {

	private final String name;
	private final Class<?> propertyType;
	private final Class<?> beanType;

	public PropertyMetadata(String name, Class<?> beanType, Class<?> propertyType) {
		this.name = name;
		this.beanType = beanType;
		this.propertyType = propertyType;
	}
	
	public Class<?> getParentType(){
		return beanType;
	}

	public String getName() {
		return name;
	}

	public Class<?> getType() {
		return propertyType;
	}

}
