package com.github.reference.application.services.actual;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.commons.convertions.ConversionService;
import com.github.commons.sequences.Sequence;
import com.github.reference.application.model.Book;
import com.github.reference.application.model.BookKey;
import com.github.reference.domain.model.BookEntity;
import com.github.reference.application.services.BookApplicationService;
import com.github.reference.domain.services.BookService;
import com.github.reference.domain.repositories.BookRepository;

public class ActualBookApplicationService implements BookApplicationService {

	private final BookService domainService;
	private final BookRepository repository;
	private final ConversionService conversionService;

	public ActualBookApplicationService(
		BookService domainService,
		BookRepository repository,
		ConversionService conversionService
	) {
		this.repository = repository;
		this.domainService = domainService;
		this.conversionService = conversionService;
	}
	public List<Book> findAll (){
		return conversionService.convertAll(Book.class, repository.findAll()).asList();
	}
	public Optional<Book> findByKey (BookKey key){
		return repository.findByKey(key.ofEntity(BookEntity.class)).map(it -> conversionService.convertTo(Book.class,it));
	}
	public Book save (Book book){
		return conversionService.convertTo(Book.class,domainService.save(conversionService.convertTo(BookEntity.class, book)));
	}
	public List<Book> saveAll (List<Book> books){
		return conversionService.convertAll(Book.class,domainService.saveAll(conversionService.convertAll(BookEntity.class, Sequence.of(books)))).asList();
	}
	public void deleteByKey (BookKey key){
		repository.findByKey(key.ofEntity(BookEntity.class)).ifPresent( instance -> domainService.delete(instance));
	}
	public void deleteAllByKeys (Set<BookKey> keys){
		domainService.deleteAll(repository.findByKeys(Sequence.of(keys).map(it -> it.ofEntity(BookEntity.class))));
	}
}
