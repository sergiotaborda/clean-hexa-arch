package com.github.commons.convertions;

import java.util.List;
import java.util.function.Function;

public class SourceListPropertyMapper<S, T, P> {

	private final AbstractFluentConverter<S, T> parent;
	private final Function<S, List<P>> sourcePropertySelector;

	public SourceListPropertyMapper(
			AbstractFluentConverter<S, T> parent,
			Function<S, List<P>> propertySelector
	) {
		this.parent =parent;
		this.sourcePropertySelector = propertySelector;
	}

	public  ListMapper<S,T,P> of(Class<P> innerType){
		return new ListMapper<S,T,P>(parent,sourcePropertySelector, innerType);
	}
	
	
}
