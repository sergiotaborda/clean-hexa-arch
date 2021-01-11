package com.github.commons.query;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class TransformationQuery<O,T> implements Query<T> {

	private final Query<O> original;
	private final Function<O, T> transform;

	public TransformationQuery(Query<O> original, Function<O,T> transform) {
		this.original = original;
		this.transform = transform;
	}
	
	@Override
	public List<T> list() {
		 return original.list().stream().map(it -> this.transform.apply(it)).collect(Collectors.toList());
	}

	@Override
	public Optional<T> first() {
		return original.first().map(it -> this.transform.apply(it));
	}


}
