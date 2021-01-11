package com.github.reference.start.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.reference.domain.services.BookService;
import com.github.reference.domain.repositories.BookRepository;
import com.github.reference.domain.services.actual.ActualBookService;
import com.github.reference.domain.services.AuthorService;
import com.github.reference.domain.repositories.AuthorRepository;
import com.github.reference.domain.services.actual.ActualAuthorService;
import com.github.reference.domain.services.AuthoringRelationService;
import com.github.reference.domain.repositories.AuthoringRelationRepository;
import com.github.reference.domain.services.actual.ActualAuthoringRelationService;

@Configuration
public class DomainConfiguration {

	@Bean
	public BookService createBookService(
		BookRepository repository
	) {
		return new ActualBookService(repository);
	}

	@Bean
	public AuthorService createAuthorService(
		AuthorRepository repository
	) {
		return new ActualAuthorService(repository);
	}

	@Bean
	public AuthoringRelationService createAuthoringRelationService(
		AuthoringRelationRepository repository
	) {
		return new ActualAuthoringRelationService(repository);
	}
}
