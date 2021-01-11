package com.github.reference.domain.services;

import java.util.List;
import java.util.Set;

import com.github.commons.sequences.Sequence;
import com.github.commons.keys.EntityKey;
import com.github.reference.domain.model.BookEntity;

public interface BookService {

	public BookEntity save (BookEntity book);
	public Sequence<BookEntity> saveAll (Sequence<BookEntity> books);
	public void delete (BookEntity book);
	public void deleteAll (Sequence<BookEntity> books);
}
