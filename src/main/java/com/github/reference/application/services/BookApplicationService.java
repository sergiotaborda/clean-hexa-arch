package com.github.reference.application.services;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.reference.application.model.Book;
import com.github.reference.application.model.BookKey;

public interface BookApplicationService {

	public List<Book> findAll ();
	public Optional<Book> findByKey (BookKey key);
	public Book save (Book book);
	public List<Book> saveAll (List<Book> books);
	public void deleteByKey (BookKey key);
	public void deleteAllByKeys (Set<BookKey> keys);
}
