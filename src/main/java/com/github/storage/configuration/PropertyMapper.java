package com.github.storage.configuration;

import com.github.commons.reflection.PropertyMetadata;

public class PropertyMapper<T, P> {

	PropertyMetadata propertyMetadata;
	boolean required = false;
	
	public PropertyMapper(PropertyMetadata propertyMetadata) {
		this.propertyMetadata = propertyMetadata;
	}

	public PropertyMapper<T, P> required() {
		required = true;
		return this;
	}


}
