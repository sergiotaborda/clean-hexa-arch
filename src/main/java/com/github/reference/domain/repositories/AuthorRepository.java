package com.github.reference.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.github.reference.domain.model.AuthorEntity;
import com.github.commons.keys.EntityKey;
import com.github.commons.sequences.Sequence;

public interface AuthorRepository {

	public Sequence<AuthorEntity> findAll();
	public Optional<AuthorEntity> findByKey (EntityKey<AuthorEntity> key);
	public Sequence<AuthorEntity> findByKeys (Sequence<EntityKey<AuthorEntity>> keys);
	public AuthorEntity save (AuthorEntity author);
	public Sequence<AuthorEntity> saveAll (Sequence<AuthorEntity> author);
	public void deleteAll (Sequence<AuthorEntity> instances);
}
