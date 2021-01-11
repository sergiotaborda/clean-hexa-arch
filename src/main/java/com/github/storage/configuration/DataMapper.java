package com.github.storage.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.github.commons.reflection.Reflection;

public class DataMapper<T> {

	private final Class<T> type;
	private final List<PropertyMapper> mappers = new ArrayList<>();
	private IdentifierMapper identifierMapper;

	DataMapper(Class<T> type){
		this.type = type;
	}
	
	Class<T> getDataType(){
		return type;
	}

	StoreDataModel getStoreDataModel(){
		var model= new StoreDataModel(this.type.getName());
		
		if (identifierMapper == null) {
			throw new IllegalStateException("An identifier field was not mapped for " + model.getName());
		}
		
		StoreDataPropertyModel property = new StoreDataPropertyModel(
				identifierMapper.propertyMetadata,
				true
		);
		
		model.add(property);
		
		for ( PropertyMapper mapper :  mappers) {
			model.add(new StoreDataPropertyModel(
					mapper.propertyMetadata,
					false
			));
		}
		
		return model;
	}
	
	
	public <P> PropertyMapper<T,P> map(Function<T,P> selectProperty) {
		var p = new PropertyMapper<T,P>(Reflection.obtainFromSelector(type, selectProperty));
		
		this.mappers.add(p);
		
		return p;
	}

	public <P> IdentifierMapper<T,P> mapIdentifier(Function<T,P> selectProperty) {
		this.identifierMapper = new IdentifierMapper<T,P>(Reflection.obtainFromSelector(type,selectProperty));
		
		return identifierMapper;
	}
	
	
}
