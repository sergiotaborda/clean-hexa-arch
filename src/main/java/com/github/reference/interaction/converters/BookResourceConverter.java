package com.github.reference.interaction.converters;

import com.github.commons.convertions.AbstractFluentConverter;
import com.github.reference.application.model.Book;
import com.github.reference.interaction.resources.BookResource;

public class BookResourceConverter extends AbstractFluentConverter<BookResource, Book > {

	public BookResourceConverter() {
		map(it -> it.getKey()).to(it-> it.getKey());
		map(it -> it.getName()).to(it-> it.getName());
		map(it -> it.getDescription()).to(it-> it.getDescription());
	}
}
