package com.github.reference.persistence.mappers;

import java.util.Map;

import com.github.reference.domain.model.AuthoringRelationEntity;
import com.github.reference.persistence.model.AuthorData;
import com.github.reference.persistence.model.BookData;

public class AuthoringRelationContext extends EntityDataMapperContext<AuthoringRelationEntity>{

	private final Map<Long, AuthorData> authors;
	private final Map<Long, BookData> books;
	
	public AuthoringRelationContext(Map<Long, AuthorData> authors, Map<Long, BookData> books) {
		this.authors = authors;
		this.books = books;
	}

	public Map<Long, AuthorData> getAuthors() {
		return authors;
	}

	public Map<Long, BookData> getBooks() {
		return books;
	}

	
	public AuthorContext getAuthorContext() {
		return new AuthorContext();
	}

	
	public BookContext getBookContext() {
		return new BookContext();
	}

}
