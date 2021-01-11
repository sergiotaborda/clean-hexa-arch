package com.github.reference.start.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.commons.convertions.ConversionService;

import com.github.reference.domain.services.BookService;
import com.github.reference.domain.repositories.BookRepository;
import com.github.reference.application.services.BookApplicationService;
import com.github.reference.application.services.actual.ActualBookApplicationService;
import com.github.reference.domain.services.AuthorService;
import com.github.reference.domain.repositories.AuthorRepository;
import com.github.reference.application.services.AuthorApplicationService;
import com.github.reference.application.services.actual.ActualAuthorApplicationService;
import com.github.reference.domain.services.AuthoringRelationService;
import com.github.reference.domain.repositories.AuthoringRelationRepository;
import com.github.reference.application.services.AuthoringRelationApplicationService;
import com.github.reference.application.services.actual.ActualAuthoringRelationApplicationService;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public BookApplicationService createBookApplicationService(
		ConversionService conversionService,
		BookService domainService,
		BookRepository repository
		) {
		return new ActualBookApplicationService(domainService,repository,conversionService);
	}

	@Bean
	public AuthorApplicationService createAuthorApplicationService(
		ConversionService conversionService,
		AuthorService domainService,
		AuthorRepository repository
		) {
		return new ActualAuthorApplicationService(domainService,repository,conversionService);
	}

	@Bean
	public AuthoringRelationApplicationService createAuthoringRelationApplicationService(
		ConversionService conversionService,
		AuthoringRelationService domainService,
		AuthoringRelationRepository repository
		) {
		return new ActualAuthoringRelationApplicationService(domainService,repository,conversionService);
	}
}
