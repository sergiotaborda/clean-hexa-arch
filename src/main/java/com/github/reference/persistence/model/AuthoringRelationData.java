package com.github.reference.persistence.model;

public class AuthoringRelationData {

	private Long id;
	private Long  authorId;
	private Long  bookId;

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getAuthorId(){
		return authorId;
	}

	public void setAuthorId(long authorId){
		this.authorId = authorId;
	}

	public Long getBookId(){
		return bookId;
	}

	public void setBookId(long bookId){
		this.bookId = bookId;
	}
}
