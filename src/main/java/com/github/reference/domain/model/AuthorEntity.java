package com.github.reference.domain.model;

import com.github.commons.keys.EntityKey;

public class AuthorEntity {

	private EntityKey<AuthorEntity> key;
	private String name;
	private String description;

	public EntityKey<AuthorEntity> getKey(){
		return this.key;
	}

	public void setKey(EntityKey<AuthorEntity> key){
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
