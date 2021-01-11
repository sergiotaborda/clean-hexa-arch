package com.github.storage.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StoreModel  {

	private final Map<String, StoreDataModel> models = new HashMap<>();
	
	StoreModel(){}
	
	public void add(StoreDataModel dataModel) {
		models.put(dataModel.getName(), dataModel);
	}
	

	public Optional<StoreDataModel> modelFor(Class<? extends Object> type) {
		return Optional.ofNullable(models.get(type.getName()));
	}

}
