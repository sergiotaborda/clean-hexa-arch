package com.github.reference.interaction.converters;

import com.github.commons.convertions.AbstractFluentConverter;
import com.github.reference.application.model.Author;
import com.github.reference.interaction.resources.AuthorResource;

public class AuthorResourceConverter extends AbstractFluentConverter<AuthorResource, Author > {

	public AuthorResourceConverter() {
		map(it -> it.getKey()).to(it-> it.getKey());
		map(it -> it.getName()).to(it-> it.getName());
		map(it -> it.getDescription()).to(it-> it.getDescription());
	}
}
