package com.github.reference.persistence.repositories;

import java.util.Collections;

import com.github.commons.query.Criteria;
import com.github.commons.sequences.Sequence;
import com.github.reference.domain.model.AuthoringRelationEntity;
import com.github.reference.domain.repositories.AuthoringRelationRepository;
import com.github.reference.persistence.DataStore;
import com.github.reference.persistence.mappers.AuthoringRelationContext;
import com.github.reference.persistence.mappers.AuthoringRelationEntityMapper;
import com.github.reference.persistence.model.AuthorData;
import com.github.reference.persistence.model.AuthoringRelationData;
import com.github.reference.persistence.model.BookData;

public class DataStoreAuthoringRepository extends AbstactDataStoreRespository<AuthoringRelationEntity, AuthoringRelationData, AuthoringRelationContext> implements AuthoringRelationRepository {

	public DataStoreAuthoringRepository(DataStore store,AuthoringRelationEntityMapper mapper) {
		super(store,mapper);
	}

	@Override
	protected AuthoringRelationContext resolveReadContext(Sequence<AuthoringRelationData> foundData) {
		
		var authorsIds = foundData.map(it -> it.getAuthorId()).asSet();
		var booksIds = foundData.map(it -> it.getAuthorId()).asSet();
		
		var authors = this.store().query(Criteria.search(AuthorData.class).whereKey().in(authorsIds).match()).sequence().asMap(it -> it.getId());
		var books = this.store().query(Criteria.search(BookData.class).whereKey().in(booksIds).match()).sequence().asMap(it -> it.getId());
		
		return new AuthoringRelationContext(authors, books);
	}

	@Override
	protected AuthoringRelationContext resolveWriteContext() {
		return new AuthoringRelationContext(Collections.emptyMap(), Collections.emptyMap());
	}

	
}
