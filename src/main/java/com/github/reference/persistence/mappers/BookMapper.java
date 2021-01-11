package com.github.reference.persistence.mappers;

import com.github.commons.keys.EntityKey;
import com.github.reference.domain.model.BookEntity;
import com.github.reference.persistence.model.BookData;

public class BookMapper implements EntityDataMapper<BookEntity, BookData, BookContext> {

	@Override
	public BookData toData(BookContext context, BookEntity entity) {
		var data = new BookData();
		
		data.setDescription(entity.getDescription());
		data.setName(entity.getName());
		if (entity.getKey() != null) {
			data.setId(entity.getKey().getLongIdentifier());
		}

		return data;
	}

	@Override
	public BookEntity fromData(BookContext context, BookData data) {
		var entity = new BookEntity();
		
		entity.setDescription(data.getDescription());
		entity.setName(data.getName());

		entity.setKey(EntityKey.ofIdentifier(BookEntity.class, data.getId()));

		return entity;
	}

	
}
