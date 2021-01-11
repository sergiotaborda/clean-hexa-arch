package com.github.reference.domain.model;

import com.github.commons.keys.EntityKey;

public class BookAuthoringEntity {

	private EntityKey<BookAuthoringEntity> key;
	private final BookEntity book;
	private final AuthorEntity author;
	
	public BookAuthoringEntity(BookEntity book, AuthorEntity author) {
		this.book = book;
		this.author = author;
	}
	
	public AuthorEntity getAuthor() {
		return author;
	}
	
	public BookEntity getBook() {
		return book;
	}

	public EntityKey<BookAuthoringEntity> getKey() {
		return key;
	}

	public void setKey(EntityKey<BookAuthoringEntity> key) {
		this.key = key;
	}

}
