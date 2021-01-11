package com.github.reference.persistence;

import com.github.commons.query.Criteria;
import com.github.commons.query.Query;

public interface DataStore {

	public <T> Query<T> query(Criteria<T> criteria);

	public <T> T store(T data);

	public <T> void delete(T data);
}
