package com.github.reference.domain.model;

import com.github.commons.keys.EntityKey;

public class BookAuthoringEntityType {

	private EntityKey<BookAuthoringEntityType> key;
	private String name;
	
	public BookAuthoringEntityType() {
	
	}
	
	public BookAuthoringEntityType(String name) {
		this.name = name;
	}

	public EntityKey<BookAuthoringEntityType> getKey() {
		return key;
	}
	
	public void setKey(EntityKey<BookAuthoringEntityType> key) {
		this.key = key;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
