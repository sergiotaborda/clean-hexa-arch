package com.github.commons.query;

import java.util.List;

public interface Criteria<T> {

	public static <X> CriteriaBuilder<X> search(Class<X> type) {
		return new CriteriaBuilder<X>(type);
	}

	public Class<T> getType();
	
	public List<Criterion> terms();
}
