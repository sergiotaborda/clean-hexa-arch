package com.github.commons.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EditableCriteria<T> implements Criteria<T> {

	private final Class<T> type;
	private final List<Criterion> criteria = new ArrayList<>();
	
	public EditableCriteria(Class<T> type) {
		this.type = type;
	}

	@Override
	public Class<T> getType() {
		return type;
	}
	
	void addCriterion(Criterion criterion){
		criteria.add(criterion);
	}

	public List<Criterion> terms(){
		return Collections.unmodifiableList(this.criteria);
	}

	

}
