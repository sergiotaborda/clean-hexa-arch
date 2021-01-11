package com.github.reference.persistence.repositories;

import com.github.commons.sequences.Sequence;
import com.github.reference.domain.model.BookEntity;
import com.github.reference.domain.repositories.BookRepository;
import com.github.reference.persistence.DataStore;
import com.github.reference.persistence.mappers.BookContext;
import com.github.reference.persistence.mappers.BookMapper;
import com.github.reference.persistence.model.BookData;

public class DataStoreBookRepository extends AbstactDataStoreRespository<BookEntity,BookData,BookContext> implements BookRepository {

	public DataStoreBookRepository(DataStore store,BookMapper mapper) {
		super(store,mapper);
	}

	@Override
	protected BookContext resolveReadContext(Sequence<BookData> foundData) {
		return new BookContext();
	}

	@Override
	protected BookContext resolveWriteContext() {
		return new BookContext();
	}
	
}