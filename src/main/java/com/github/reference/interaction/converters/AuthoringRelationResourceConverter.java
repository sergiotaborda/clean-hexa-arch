package com.github.reference.interaction.converters;

import com.github.commons.convertions.AbstractFluentConverter;
import com.github.reference.application.model.AuthoringRelation;
import com.github.reference.interaction.resources.AuthoringRelationResource;

public class AuthoringRelationResourceConverter extends AbstractFluentConverter<AuthoringRelationResource, AuthoringRelation > {

	public AuthoringRelationResourceConverter() {
		map(it -> it.getKey()).to(it-> it.getKey());
		map(it -> it.getAuthor()).to(it-> it.getAuthor());
		map(it -> it.getBook()).to(it-> it.getBook());
	}
}
