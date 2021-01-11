package com.github.reference.domain.model;

import java.util.Optional;

public class BookEntityFilter {

	private String name;

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
