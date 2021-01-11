package com.github.reference.store.mapping;

import com.github.reference.persistence.model.AuthoringRelationData;
import com.github.storage.configuration.DataMapper;
import com.github.storage.configuration.DataMapping;

public class AuthoringRelationDataMapping extends DataMapping<AuthoringRelationData> {

	public void configureMapping(DataMapper<AuthoringRelationData> mapper){
		mapper.mapIdentifier(it -> it.getId()).autoIncrement();
		mapper.map(it -> it.getAuthorId()).required();
		mapper.map(it -> it.getBookId());
	}
}
