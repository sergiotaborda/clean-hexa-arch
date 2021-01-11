package com.github.commons.query;

import com.github.commons.reflection.PropertyMetadata;

public class WhereFieldBuider<T, P> {

	private PropertyMetadata property;
	private CriteriaBuilder<T> criteriaBuilder;

	public WhereFieldBuider(CriteriaBuilder<T> criteriaBuilder, PropertyMetadata property) {
		this.criteriaBuilder = criteriaBuilder;
		this.property = property;
	}

	
	public CriteriaBuilder<T> is(P value) {
		
		criteriaBuilder.addCriterion(new NameValueFieldCriterion(property, ComparisonOperator.EQUALS, value));
		
		return criteriaBuilder;
	}
}
