package com.github.commons.convertions;

import java.util.function.Function;

public class SourcePropertyMapper<S, T, P> {

	
	private final AbstractFluentConverter<S, T> parent;
	private final Function<S, P> sourcePropertySelector;

	public SourcePropertyMapper(
			AbstractFluentConverter<S, T> parent,
			Function<S, P> propertySelector
	) {
		this.parent =parent;
		this.sourcePropertySelector = propertySelector;
	}

	public <R> void to(Function<T,R> targetPropertySelector) {
		
		
		parent.add(new PropertyMapping<S,T,P,R>(parent.getSourceType(),parent.getTargetType(),sourcePropertySelector, targetPropertySelector));
	}
	
}
