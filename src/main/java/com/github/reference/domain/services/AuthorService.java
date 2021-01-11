package com.github.reference.domain.services;

import java.util.List;
import java.util.Set;

import com.github.commons.sequences.Sequence;
import com.github.commons.keys.EntityKey;
import com.github.reference.domain.model.AuthorEntity;

public interface AuthorService {

	public AuthorEntity save (AuthorEntity author);
	public Sequence<AuthorEntity> saveAll (Sequence<AuthorEntity> authors);
	public void delete (AuthorEntity author);
	public void deleteAll (Sequence<AuthorEntity> authors);
}
