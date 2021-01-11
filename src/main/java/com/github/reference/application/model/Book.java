package com.github.reference.application.model;

public class Book {

	private BookKey key;
	private String name;
	private String description;

	public BookKey getKey(){
		return this.key;
	}

	public void setKey(BookKey key){
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
