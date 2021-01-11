package com.github.reference.store.mapping;

import com.github.reference.persistence.model.BookData;
import com.github.storage.configuration.DataMapper;
import com.github.storage.configuration.DataMapping;

public class BookDataMapping extends DataMapping<BookData> {

	public void configureMapping(DataMapper<BookData> mapper){
		mapper.mapIdentifier(it -> it.getId()).autoIncrement();
		mapper.map(it -> it.getName()).required();
		mapper.map(it -> it.getDescription());
	}
}
