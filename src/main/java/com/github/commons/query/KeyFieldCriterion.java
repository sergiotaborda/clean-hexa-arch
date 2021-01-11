package com.github.commons.query;

public class KeyFieldCriterion implements Criterion  {

	private final Object value;
	private final ComparisonOperator operator;

	public KeyFieldCriterion(ComparisonOperator operator, Object value) {
		this.value = value;
		this.operator = operator;
	}

	@Override
	public ComparisonOperator operator() {
		return operator;
	}


	public Object getValue() {
		return value;
	}

}
