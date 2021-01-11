package com.github.reference.application.model;

public class AuthoringRelation {

	private AuthoringRelationKey key;
	private Author author;
	private Book book;

	public AuthoringRelationKey getKey(){
		return this.key;
	}

	public void setKey(AuthoringRelationKey key){
		this.key = key;
	}

	public Author getAuthor(){
		return author;
	}

	public void setAuthor(Author author){
		this.author = author;
	}

	public Book getBook(){
		return book;
	}

	public void setBook(Book book){
		this.book = book;
	}
}
