package com.github.reference.start.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.storage.configuration.StoreModel;
import com.github.storage.configuration.StoreModelReader;
import com.github.reference.store.mapping.BookDataMapping;
import com.github.reference.store.mapping.AuthorDataMapping;
import com.github.reference.store.mapping.AuthoringRelationDataMapping;

@Configuration
public class DataMappingConfiguration {

	@Bean
	public StoreModel readmodel() {
	return new StoreModelReader()
			.add(new BookDataMapping())
			.add(new AuthorDataMapping())
			.add(new AuthoringRelationDataMapping())
			.read();
	}
}
