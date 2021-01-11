package com.github.reference.interaction.resources;

public class AuthoringRelationResource {

	private String key;
	private AuthorResource author;
	private BookResource book;

	public String getKey(){
		return this.key;
	}

	public void setKey(String key){
		this.key = key;
	}

	public AuthorResource getAuthor(){
		return author;
	}

	public void setAuthor(AuthorResource author){
		this.author = author;
	}

	public BookResource getBook(){
		return book;
	}

	public void setBook(BookResource book){
		this.book = book;
	}
}
