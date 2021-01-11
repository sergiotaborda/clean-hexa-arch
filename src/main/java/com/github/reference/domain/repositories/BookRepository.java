package com.github.reference.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.github.reference.domain.model.BookEntity;
import com.github.commons.keys.EntityKey;
import com.github.commons.sequences.Sequence;

public interface BookRepository {

	public Sequence<BookEntity> findAll();
	public Optional<BookEntity> findByKey (EntityKey<BookEntity> key);
	public Sequence<BookEntity> findByKeys (Sequence<EntityKey<BookEntity>> keys);
	public BookEntity save (BookEntity book);
	public Sequence<BookEntity> saveAll (Sequence<BookEntity> book);
	public void deleteAll (Sequence<BookEntity> instances);
}
