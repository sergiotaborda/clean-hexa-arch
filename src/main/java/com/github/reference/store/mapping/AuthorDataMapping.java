package com.github.reference.store.mapping;

import com.github.reference.persistence.model.AuthorData;
import com.github.storage.configuration.DataMapper;
import com.github.storage.configuration.DataMapping;

public class AuthorDataMapping extends DataMapping<AuthorData> {

	public void configureMapping(DataMapper<AuthorData> mapper){
		mapper.mapIdentifier(it -> it.getId()).autoIncrement();
		mapper.map(it -> it.getName()).required();
		mapper.map(it -> it.getDescription());
	}
}
