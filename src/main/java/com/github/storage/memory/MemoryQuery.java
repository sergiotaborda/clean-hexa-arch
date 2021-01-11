package com.github.storage.memory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.commons.query.ComparisonOperator;
import com.github.commons.query.Criteria;
import com.github.commons.query.Criterion;
import com.github.commons.query.KeyCollectionFieldCriterion;
import com.github.commons.query.KeyFieldCriterion;
import com.github.commons.query.NameValueFieldCriterion;
import com.github.commons.query.Query;
import com.github.storage.configuration.StoreDataModel;
import com.github.storage.configuration.StoreModel;

public class MemoryQuery<T> implements Query<T> {

	private final Map<Long, Object> slot;
	private final Criteria<T> criteria;
	private final StoreModel model;

	public MemoryQuery(Map<Long, Object> slot, Criteria<T> criteria, StoreModel model) {
		this.slot = slot;
		this.criteria = criteria;
		this.model = model;
	}

	@Override
	public List<T> list() {
		return slot.values().stream().filter( it -> this.accept(it)).map(it -> criteria.getType().cast(it)).collect(Collectors.toList());
	}

	private boolean  accept(Object instance) {

		StoreDataModel datamodel = model.modelFor(criteria.getType()).orElseThrow(() -> new IllegalStateException("Model not found for " + criteria.getType().getName()));


		for (Criterion c : criteria.terms()) {

			if (c instanceof NameValueFieldCriterion) {
				NameValueFieldCriterion fc  = (NameValueFieldCriterion)c;
				if (!match(datamodel.getProperty(fc.getName()).readValue(instance), fc.operator(), fc.getValue())){
					return false;
				};
			} else if (c instanceof KeyFieldCriterion) {
				KeyFieldCriterion kc  = (KeyFieldCriterion)c;
				if (!match(datamodel.getKeyProperty().readValue(instance), kc.operator(), kc.getValue())){
					return false;
				};
			} else if (c instanceof KeyCollectionFieldCriterion) {
				KeyCollectionFieldCriterion kc  = (KeyCollectionFieldCriterion)c;
				
				if (kc.operator() == ComparisonOperator.IN) {
					return kc.getValues().contains(datamodel.getKeyProperty().readValue(instance));
				}
				return false;
			}

		}

		return true;
	}

	private boolean match(Object value, ComparisonOperator operator, Object expected) {
		switch(operator) {
		case EQUALS:
			return value.equals(expected);
		case NOT_EQUALS:
			return !value.equals(expected);
		default:
			return false;
		}
	}

	@Override
	public Optional<T> first() {
		return slot.values().stream().filter( it -> this.accept(it)).findAny().map(it -> criteria.getType().cast(it));
	}

}
