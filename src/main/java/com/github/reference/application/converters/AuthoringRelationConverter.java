package com.github.reference.application.converters;

import com.github.commons.convertions.AbstractFluentConverter;
import com.github.reference.application.model.AuthoringRelation;
import com.github.reference.domain.model.AuthoringRelationEntity;

public class AuthoringRelationConverter extends AbstractFluentConverter<AuthoringRelation, AuthoringRelationEntity> {

	public AuthoringRelationConverter() {
		map(it -> it.getKey()).to(it-> it.getKey());
		map(it -> it.getAuthor()).to(it-> it.getAuthor());
		map(it -> it.getBook()).to(it-> it.getBook());
	}
}
