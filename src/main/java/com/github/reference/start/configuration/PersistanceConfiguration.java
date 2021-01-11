package com.github.reference.start.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.reference.domain.repositories.AuthorRepository;
import com.github.reference.domain.repositories.AuthoringRelationRepository;
import com.github.reference.domain.repositories.BookRepository;
import com.github.reference.persistence.DataStore;
import com.github.reference.persistence.mappers.AuthorMapper;
import com.github.reference.persistence.mappers.AuthoringRelationEntityMapper;
import com.github.reference.persistence.mappers.BookMapper;
import com.github.reference.persistence.repositories.DataStoreAuthorRepository;
import com.github.reference.persistence.repositories.DataStoreAuthoringRepository;
import com.github.reference.persistence.repositories.DataStoreBookRepository;

@Configuration
public class PersistanceConfiguration {


	@Bean
	public BookRepository bookRepository(DataStore dataStore) {
		return new DataStoreBookRepository(dataStore, new BookMapper());
	}
	
	@Bean
	public AuthorRepository authorRepository(DataStore dataStore) {
		return new DataStoreAuthorRepository(dataStore,new AuthorMapper());
	}
	
	@Bean
	public AuthoringRelationRepository authoringRelationRepository(DataStore dataStore) {
		return new DataStoreAuthoringRepository(dataStore, new AuthoringRelationEntityMapper(new BookMapper(), new AuthorMapper()));
	}
	
}
