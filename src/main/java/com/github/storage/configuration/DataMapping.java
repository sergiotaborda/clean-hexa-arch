package com.github.storage.configuration;

import java.lang.reflect.ParameterizedType;

public abstract class DataMapping<T> {

	
	StoreDataModel getModel() {
		var typeArguments = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
		var mapper = new DataMapper<T>((Class<T>) typeArguments[0]);
		
		configureMapping(mapper);
		
		return mapper.getStoreDataModel();
	}
	
	protected abstract void configureMapping(DataMapper<T> mapper);
}
