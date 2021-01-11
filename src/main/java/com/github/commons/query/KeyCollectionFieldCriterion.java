package com.github.commons.query;

import java.util.Set;

public class KeyCollectionFieldCriterion implements Criterion  {

	private final Set<Object> values;
	private final ComparisonOperator operator;

	public KeyCollectionFieldCriterion(ComparisonOperator operator, Set<? extends Object> values) {
		this.values = (Set<Object>) values;
		this.operator = operator;
	}

	@Override
	public ComparisonOperator operator() {
		return operator;
	}


	public Set<Object> getValues() {
		return values;
	}

}
