package com.github.reference.domain.model;

import com.github.commons.keys.EntityKey;

public class AuthoringRelationEntity {

	private EntityKey<AuthoringRelationEntity> key;
	private AuthorEntity author;
	private BookEntity book;

	public EntityKey<AuthoringRelationEntity> getKey(){
		return this.key;
	}

	public void setKey(EntityKey<AuthoringRelationEntity> key){
		this.key = key;
	}

	public AuthorEntity getAuthor(){
		return author;
	}

	public void setAuthor(AuthorEntity author){
		this.author = author;
	}

	public BookEntity getBook(){
		return book;
	}

	public void setBook(BookEntity book){
		this.book = book;
	}
}
