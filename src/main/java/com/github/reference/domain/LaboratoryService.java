package com.github.reference.domain;

import com.github.reference.domain.model.AuthorEntity;

public interface LaboratoryService {

	
	public AuthorEntity save(AuthorEntity laboratory);

	public void delete(AuthorEntity laboratory);
}

