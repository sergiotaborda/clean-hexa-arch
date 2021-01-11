package com.github.commons.convertions;

import java.util.List;
import java.util.function.Function;

public class ListMapper<S, T, P> {

	private final AbstractFluentConverter<S, T> parent;
	private final Function<S, List<P>> sourcePropertySelector;
	private final Class<P> innerType;

	public ListMapper(
			AbstractFluentConverter<S, T> parent,
			Function<S, List<P>> propertySelector,
			Class<P> innerType
	) {
		this.parent =parent;
		this.sourcePropertySelector = propertySelector;
		this.innerType =innerType;
	}

	public <R> EndListMapper<S,T, P, R> toList(Function<T, List<R>> targetPropertySelector) {
		
		return new EndListMapper<S,T,P, R>(parent, sourcePropertySelector, targetPropertySelector , innerType);
		
	}
}
