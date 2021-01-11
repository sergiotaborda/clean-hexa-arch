package com.github.reference.persistence.mappers;

import com.github.commons.keys.EntityKey;
import com.github.reference.domain.model.AuthorEntity;
import com.github.reference.persistence.model.AuthorData;

public class AuthorMapper implements EntityDataMapper<AuthorEntity, AuthorData,AuthorContext> {

	@Override
	public AuthorData toData(AuthorContext context, AuthorEntity entity) {
		var data = new AuthorData();
		
		data.setDescription(entity.getDescription());
		data.setName(entity.getName());
		if (entity.getKey() != null) {
			data.setId(entity.getKey().getLongIdentifier());
		}

		return data;
	}

	@Override
	public AuthorEntity fromData(AuthorContext context,AuthorData data) {
		var entity = new AuthorEntity();
		
		entity.setDescription(data.getDescription());
		entity.setName(data.getName());

		entity.setKey(EntityKey.ofIdentifier(AuthorEntity.class, data.getId()));

		return entity;
	}


}
