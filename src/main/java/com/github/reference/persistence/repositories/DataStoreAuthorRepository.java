package com.github.reference.persistence.repositories;

import com.github.commons.sequences.Sequence;
import com.github.reference.domain.model.AuthorEntity;
import com.github.reference.domain.repositories.AuthorRepository;
import com.github.reference.persistence.DataStore;
import com.github.reference.persistence.mappers.AuthorContext;
import com.github.reference.persistence.mappers.AuthorMapper;
import com.github.reference.persistence.model.AuthorData;

public class DataStoreAuthorRepository extends AbstactDataStoreRespository<AuthorEntity,AuthorData, AuthorContext> implements AuthorRepository {

	public DataStoreAuthorRepository(DataStore store, AuthorMapper mapper) {
		super(store,mapper);
	}

	@Override
	protected AuthorContext resolveReadContext(Sequence<AuthorData> foundData) {
		return new AuthorContext();
	}

	@Override
	protected AuthorContext resolveWriteContext() {
		return new AuthorContext();
	}

	

	
}
