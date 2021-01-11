package com.github.commons.query;

import java.util.function.Function;

import com.github.commons.reflection.Reflection;

public final class CriteriaBuilder<T> {


	private final EditableCriteria<T> criteria;
	
    CriteriaBuilder(Class<T> type) {
		criteria = new EditableCriteria<T>(type);
	}

	public WhereKeyFieldBuider<T> whereKey(){
		return new WhereKeyFieldBuider<>(this);
	}

	public <P> WhereFieldBuider<T,P>  whereField(Function<T,P> propertySelector) {
		
		return new WhereFieldBuider<T, P>(this,Reflection.obtainFromSelector(criteria.getType(), propertySelector));
	}

	void addCriterion(Criterion fieldCriterion) {
		 criteria.addCriterion(fieldCriterion);
	}
	
	public Criteria<T> match(){
		return criteria;
	}

	

}
