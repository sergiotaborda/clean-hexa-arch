package com.github.storage.configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StoreDataModel {

	private final Map<String,StoreDataPropertyModel> properties = new HashMap<>();
	private StoreDataPropertyModel keyProperty;
	
	private final String name;

	public StoreDataModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public Collection<StoreDataPropertyModel> getProperties() {
		return Collections.unmodifiableCollection(properties.values());
	}


	public void add(StoreDataPropertyModel property) {
		this.properties.put(property.getName().toLowerCase(), property);
		if(property.isIdentifier()) {
			this.keyProperty = property;
		}
	}

	public StoreDataPropertyModel getKeyProperty() {
		return keyProperty;
	}
	
	public StoreDataPropertyModel getProperty(String name) {
		return properties.get(name.toLowerCase());
	}
}
