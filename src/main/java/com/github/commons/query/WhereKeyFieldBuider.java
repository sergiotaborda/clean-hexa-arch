package com.github.commons.query;

import java.util.Set;

public class WhereKeyFieldBuider<T> {


	private CriteriaBuilder<T> criteriaBuilder;

	public WhereKeyFieldBuider(CriteriaBuilder<T> criteriaBuilder) {
		this.criteriaBuilder = criteriaBuilder;
	}

	
	public CriteriaBuilder<T> is(Object value) {
		
		criteriaBuilder.addCriterion(new KeyFieldCriterion(ComparisonOperator.EQUALS,value));
		
		return criteriaBuilder;
	}


	
	public CriteriaBuilder<T> in(Set<? extends Object> values) {
	
		criteriaBuilder.addCriterion(new KeyCollectionFieldCriterion(ComparisonOperator.IN,values));
		
		return criteriaBuilder;
	}
}
