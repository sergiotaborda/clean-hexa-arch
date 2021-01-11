package com.github.reference.interaction.resources;

public class BookResource {

	private String key;
	private String name;
	private String description;

	public String getKey(){
		return this.key;
	}

	public void setKey(String key){
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
