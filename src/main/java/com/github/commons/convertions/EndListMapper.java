package com.github.commons.convertions;

import java.util.List;
import java.util.function.Function;

public class EndListMapper<S, T, P, R> {
	
	private final AbstractFluentConverter<S, T> parent;
	private final Function<S, List<P>> sourcePropertySelector;
	private final Class<P> innerType;
	private final Function<T, List<R>> targetPropertySelector;

	public EndListMapper(
			AbstractFluentConverter<S, T> parent,
			Function<S, List<P>> propertySelector,
			Function<T, List<R>> targetSelector,
			Class<P> innerType
	) {
		this.parent =parent;
		this.sourcePropertySelector = propertySelector;
		this.targetPropertySelector = targetSelector;
		this.innerType =innerType;
	}

	public void of(Class<R> innerTargetType) {
		
		
		parent.add(new ListPropertyMapping<S,T,P,R>(parent.getSourceType(),parent.getTargetType(),sourcePropertySelector, targetPropertySelector, innerType, innerTargetType));
		
	}
}
