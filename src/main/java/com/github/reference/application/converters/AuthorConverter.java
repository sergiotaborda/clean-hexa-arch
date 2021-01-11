package com.github.reference.application.converters;

import com.github.commons.convertions.AbstractFluentConverter;
import com.github.reference.application.model.Author;
import com.github.reference.domain.model.AuthorEntity;

public class AuthorConverter extends AbstractFluentConverter<Author, AuthorEntity> {

	public AuthorConverter() {
		map(it -> it.getKey()).to(it-> it.getKey());
		map(it -> it.getName()).to(it-> it.getName());
		map(it -> it.getDescription()).to(it-> it.getDescription());
	}
}
