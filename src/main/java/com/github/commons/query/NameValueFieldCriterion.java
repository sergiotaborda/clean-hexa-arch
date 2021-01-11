package com.github.commons.query;

import com.github.commons.reflection.PropertyMetadata;

public class NameValueFieldCriterion implements Criterion {

	private final Object value;
	private final PropertyMetadata property;
	private final ComparisonOperator operator;

	public NameValueFieldCriterion(PropertyMetadata property,ComparisonOperator operator, Object value) {
		this.property = property;
		this.value = value;
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public String getName() {
		return property.getName();
	}

	
	@Override
	public ComparisonOperator operator() {
		return operator;
	}

}
