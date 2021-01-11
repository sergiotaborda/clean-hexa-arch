package com.github.reference.domain.services.actual;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.commons.sequences.Sequence;
import com.github.commons.convertions.ConversionService;
import com.github.reference.application.model.Author;
import com.github.reference.application.model.AuthorKey;
import com.github.reference.domain.model.AuthorEntity;
import com.github.reference.domain.services.AuthorService;
import com.github.reference.domain.repositories.AuthorRepository;

public class ActualAuthorService implements AuthorService {

	private final AuthorRepository repository;

	public ActualAuthorService(
		AuthorRepository repository
	) {
		this.repository = repository;
	}
	public AuthorEntity save (AuthorEntity author){
		//TODO valiation
		return repository.save(author);
	}
	public Sequence<AuthorEntity> saveAll (Sequence<AuthorEntity> authors){
		//TODO valiation
		return repository.saveAll(authors);
	}
	public void delete (AuthorEntity author){
		//TODO valiation
		repository.deleteAll(Sequence.of(author));
	}
	public void deleteAll (Sequence<AuthorEntity> authors){
		//TODO valiation
		repository.deleteAll(authors);
	}
}
