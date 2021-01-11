package com.github.reference.start.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.reference.persistence.DataStore;
import com.github.storage.configuration.StoreModel;
import com.github.storage.memory.MemoryDataStore;

@Configuration
public class DataStoreConfiguration {

	
	@Bean 
	public DataStore configDatastore(StoreModel storeModel) {
		return new MemoryDataStore(storeModel);	
	}
}
