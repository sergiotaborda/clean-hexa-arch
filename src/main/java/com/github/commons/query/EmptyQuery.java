package com.github.commons.query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class EmptyQuery<T> implements Query<T> {

	@SuppressWarnings("rawtypes")
	public static EmptyQuery me = new EmptyQuery();
		
	@SuppressWarnings("unchecked") //correct by singleton design rules
	public static <X> EmptyQuery<X> instance(){
		return me;
	}
	
	@Override
	public List<T> list() {
		return Collections.emptyList();
	}

	@Override
	public Optional<T> first() {
		return Optional.empty();
	}

	@SuppressWarnings("unchecked") //correct by singleton design rules
	public <R> Query<R> map(Function<T,R> transformation) {
		// a transformation over an empty query is an empty query
		return me;
	}

	
}
