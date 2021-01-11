package com.github.reference.domain.services.actual;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.commons.sequences.Sequence;
import com.github.commons.convertions.ConversionService;
import com.github.reference.application.model.Book;
import com.github.reference.application.model.BookKey;
import com.github.reference.domain.model.BookEntity;
import com.github.reference.domain.services.BookService;
import com.github.reference.domain.repositories.BookRepository;

public class ActualBookService implements BookService {

	private final BookRepository repository;

	public ActualBookService(
		BookRepository repository
	) {
		this.repository = repository;
	}
	public BookEntity save (BookEntity book){
		//TODO valiation
		return repository.save(book);
	}
	public Sequence<BookEntity> saveAll (Sequence<BookEntity> books){
		//TODO valiation
		return repository.saveAll(books);
	}
	public void delete (BookEntity book){
		//TODO valiation
		repository.deleteAll(Sequence.of(book));
	}
	public void deleteAll (Sequence<BookEntity> books){
		//TODO valiation
		repository.deleteAll(books);
	}
}
