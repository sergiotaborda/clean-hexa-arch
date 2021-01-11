package com.github.reference.application.services.actual;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.commons.convertions.ConversionService;
import com.github.commons.sequences.Sequence;
import com.github.reference.application.model.Author;
import com.github.reference.application.model.AuthorKey;
import com.github.reference.domain.model.AuthorEntity;
import com.github.reference.application.services.AuthorApplicationService;
import com.github.reference.domain.services.AuthorService;
import com.github.reference.domain.repositories.AuthorRepository;

public class ActualAuthorApplicationService implements AuthorApplicationService {

	private final AuthorService domainService;
	private final AuthorRepository repository;
	private final ConversionService conversionService;

	public ActualAuthorApplicationService(
		AuthorService domainService,
		AuthorRepository repository,
		ConversionService conversionService
	) {
		this.repository = repository;
		this.domainService = domainService;
		this.conversionService = conversionService;
	}
	public List<Author> findAll (){
		return conversionService.convertAll(Author.class, repository.findAll()).asList();
	}
	public Optional<Author> findByKey (AuthorKey key){
		return repository.findByKey(key.ofEntity(AuthorEntity.class)).map(it -> conversionService.convertTo(Author.class,it));
	}
	public Author save (Author author){
		return conversionService.convertTo(Author.class,domainService.save(conversionService.convertTo(AuthorEntity.class, author)));
	}
	public List<Author> saveAll (List<Author> authors){
		return conversionService.convertAll(Author.class,domainService.saveAll(conversionService.convertAll(AuthorEntity.class, Sequence.of(authors)))).asList();
	}
	public void deleteByKey (AuthorKey key){
		repository.findByKey(key.ofEntity(AuthorEntity.class)).ifPresent( instance -> domainService.delete(instance));
	}
	public void deleteAllByKeys (Set<AuthorKey> keys){
		domainService.deleteAll(repository.findByKeys(Sequence.of(keys).map(it -> it.ofEntity(AuthorEntity.class))));
	}
}
