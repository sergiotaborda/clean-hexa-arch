package com.github.reference.persistence.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import com.github.commons.keys.EntityKey;
import com.github.commons.query.Criteria;
import com.github.commons.sequences.Sequence;
import com.github.reference.domain.model.BookEntity;
import com.github.reference.persistence.DataStore;
import com.github.reference.persistence.mappers.BookContext;
import com.github.reference.persistence.mappers.EntityDataMapper;
import com.github.reference.persistence.mappers.EntityDataMapperContext;
import com.github.reference.persistence.model.BookData;

import springfox.documentation.spring.data.rest.EntityAssociationContext;

public abstract class AbstactDataStoreRespository<T,D, C extends EntityDataMapperContext<T>> {

	private final DataStore store;
	private final Class<D> dataType;
	private final EntityDataMapper<T, D, C> mapper;

	@SuppressWarnings("unchecked") // by java design
	public AbstactDataStoreRespository(DataStore store, EntityDataMapper<T, D, C> mapper) {
		this.store = store;
		this.mapper = mapper;
				
		var typeArguments = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
	    this.dataType 	= (Class<D>) typeArguments[1];
	}
	

	public Sequence<T> findAll() {
		var foundData =  store.query(Criteria.search(dataType).match()).sequence();
		
		var context = resolveReadContext(foundData);
		
		return foundData.map(data -> mapper.fromData(context, data));
	}

	public Optional<T> findByKey(EntityKey<T> key) {
		return store.query(Criteria.search(dataType).whereKey().is(key.getLongIdentifier()).match()).first()
				.map(data -> {
					
					var context = resolveReadContext(Sequence.of(data));
					
					return mapper.fromData(context, data);
				});
	}

	public Sequence<T> findByKeys(Sequence<EntityKey<T>> keys) {
		var foundData = store.query(Criteria.search(dataType).whereKey().in(keys.map(it -> it.getLongIdentifier()).asSet()).match()).sequence();
		
		var context = resolveReadContext(foundData);
		
		return foundData.map(data -> mapper.fromData(context, data));
	}

	public T save(T instance) {
		var data = store.store(mapper.toData(resolveWriteContext(), instance));
	
		return mapper.fromData(resolveReadContext(Sequence.of(data)) , data);
	}
	
	public Sequence<T> saveAll(Sequence<T> instances) {
		
		var context = resolveWriteContext();
		
		var stored = instances.map(it -> store.store( mapper.toData(context, it)));
		
		var readContext = resolveReadContext(stored);
		
		return stored.map(it ->  mapper.fromData(readContext , it));
	}
	
	public void deleteAll(Sequence<T> instances) {
		var context = resolveWriteContext();
		for (var instance : instances) {
		  store.delete(mapper.toData(context, instance));
		}
	}
	
	protected DataStore store() {
		return store;
	}
	
	protected abstract C resolveReadContext(Sequence<D> foundData);
	
	protected abstract C resolveWriteContext();

}
