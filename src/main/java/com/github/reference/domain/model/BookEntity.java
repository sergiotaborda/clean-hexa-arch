package com.github.reference.domain.model;

import com.github.commons.keys.EntityKey;

public class BookEntity {

	private EntityKey<BookEntity> key;
	private String name;
	private String description;

	public EntityKey<BookEntity> getKey(){
		return this.key;
	}

	public void setKey(EntityKey<BookEntity> key){
		this.key = key;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}
}
