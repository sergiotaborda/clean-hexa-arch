package com.github.storage.configuration;

import java.util.ArrayList;
import java.util.List;

public class StoreModelReader {

	private List<DataMapping> mappers = new ArrayList<>();
	
	public <T> StoreModelReader add(DataMapping<T> mapping) {
		
		mappers.add(mapping);
		
		return this;
	}
	
	public StoreModel read() {
		var model =  new StoreModel();
		
		for (var m : mappers) {
		
			model.add(m.getModel());
		}
		
		return model;
	}
}
