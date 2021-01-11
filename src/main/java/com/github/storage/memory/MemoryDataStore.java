package com.github.storage.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.github.commons.query.Criteria;
import com.github.commons.query.Query;
import com.github.reference.persistence.DataStore;
import com.github.storage.configuration.StoreModel;

/**
 * 
 * Simple memory DataStore.
 * 
 * The DataStore interface can be implement against any persistence technology or against a in memory technology like MemCache or Redis
 * The StoreModel provides the technology agnostic meta model  that drives the DataStore implementation 
 * 
 * The criteria API is also agnostic so rules are independent of storage. An implementation of Query applies the criteria for each technology 
 */
public class MemoryDataStore implements DataStore {

	
	private final Map<String, Map<Long, Object>> memory = new HashMap<>();
	private final Map<String, Long> keys = new HashMap<>();
	private final StoreModel storeModel;
	
	public MemoryDataStore(StoreModel storeModel) {
		this.storeModel = storeModel;
	}
	
	@Override
	public <T> Query<T> query(Criteria<T> criteria) {
		Map<Long, Object> slot =  memory.get(criteria.getType().getName());
		
		if (slot == null) {
			return Query.empty();
		}
		
		return new MemoryQuery<T>(slot,criteria,storeModel);
	}

	@Override
	public <T> T store(T data) {
		if (data != null) {
			Optional<Long> key = getKey(data);
			Long keyValue;
			if (key.isPresent()) {
				keyValue = key.get();
			} else {
				keyValue = generateKey(data.getClass());
				storeModel.modelFor(data.getClass()).ifPresent( m -> m.getKeyProperty().writeValue(data, keyValue));
			}

			resolveSlot(data.getClass()).put(keyValue, data);
		
		}	
		return data;
	}

	private Long generateKey(Class<? extends Object> type) {
		Long key = keys.get(type.getName());
		if ( key == null) {
			key = 1L;
		} else {
			key += 1;
		}
		keys.put(type.getName(), key);
		
		return key;
	}

	@Override
	public <T> void delete(T data) {
		if (data != null) {
			
			Map<Long, Object> slot = memory.get(data.getClass().getName());
			Optional<Long> key = getKey(data);
			
			if(slot != null && key.isPresent()) {
			
				slot.remove(key.get());
			}
		}
	}
	
	private Optional<Long> getKey(Object obj) {
		return storeModel.modelFor(obj.getClass()).map( m -> (Long)m.getKeyProperty().readValue(obj));
	}
	
	private Map<Long, Object> resolveSlot (Class<?> type){
		Map<Long, Object> slot = memory.get(type.getName());
		
		if(slot == null) {
			slot = new HashMap<>();
			memory.put(type.getName(), slot);
		}
		
		return slot;
	}



}
