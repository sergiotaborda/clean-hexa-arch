package com.github.reference.persistence.mappers;

import java.util.Optional;

import com.github.commons.keys.EntityKey;
import com.github.reference.domain.model.AuthoringRelationEntity;
import com.github.reference.persistence.model.AuthoringRelationData;

public class AuthoringRelationEntityMapper implements EntityDataMapper<AuthoringRelationEntity,AuthoringRelationData,AuthoringRelationContext>{

	
	private BookMapper bookMapper;
	private AuthorMapper authorMapper;

	public AuthoringRelationEntityMapper(
			BookMapper bookMapper, 
			AuthorMapper authorMapper
	) {
		this.bookMapper = bookMapper;
		this.authorMapper = authorMapper;
	}
	
	@Override
	public AuthoringRelationData toData(AuthoringRelationContext context, AuthoringRelationEntity entity) {
		var data = new AuthoringRelationData();
		
		
		if (entity.getAuthor() != null && entity.getAuthor().getKey() != null) {
			data.setAuthorId(entity.getAuthor().getKey().getLongIdentifier());
		}
		
		if (entity.getBook() != null && entity.getBook().getKey() != null) {
			data.setAuthorId(entity.getBook().getKey().getLongIdentifier());
		}
		
		if (entity.getKey() != null) {
			data.setId(entity.getKey().getLongIdentifier());
		}

		return data;
	}

	@Override
	public AuthoringRelationEntity fromData(AuthoringRelationContext context,AuthoringRelationData data) {
		var entity = new AuthoringRelationEntity();
		
		Optional.ofNullable(context.getAuthors().get(data.getAuthorId())).map(a -> authorMapper.fromData(context.getAuthorContext(), a)).ifPresent(it -> entity.setAuthor(it));
		Optional.ofNullable(context.getBooks().get(data.getBookId())).map(a -> bookMapper.fromData(context.getBookContext(), a)).ifPresent(it -> entity.setBook(it));

		entity.setKey(EntityKey.ofIdentifier(AuthoringRelationEntity.class, data.getId()));

		return entity;
	}

}
