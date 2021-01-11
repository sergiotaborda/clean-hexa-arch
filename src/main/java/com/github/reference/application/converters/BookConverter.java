package com.github.reference.application.converters;

import com.github.commons.convertions.AbstractFluentConverter;
import com.github.reference.application.model.Book;
import com.github.reference.domain.model.BookEntity;

public class BookConverter extends AbstractFluentConverter<Book, BookEntity> {

	public BookConverter() {
		map(it -> it.getKey()).to(it-> it.getKey());
		map(it -> it.getName()).to(it-> it.getName());
		map(it -> it.getDescription()).to(it-> it.getDescription());
	}
}
