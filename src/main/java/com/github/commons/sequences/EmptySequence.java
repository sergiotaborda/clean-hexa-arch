package com.github.commons.sequences;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

class EmptySequence<T> implements Sequence<T> {

	@SuppressWarnings("rawtypes")
	static EmptySequence me = new EmptySequence();
	
	@SuppressWarnings("unchecked") 
	static final <X> EmptySequence<X> instance(){
		return me;
	}
	
	@Override
	public Iterator<T> iterator() {
		return Collections.emptyIterator();
	}
	
	@Override
	public Set<T> asSet() {
		return Collections.emptySet();
	}
	
	@Override
	public List<T> asList() {
		return Collections.emptyList();
	}

	@Override
	public <K> Map<K, T> asMap(Function<T, K> keySelector) {
		return Collections.emptyMap();
	}

	@Override
	public <K, V> Map<K, V> asMap(Function<T, K> keySelector, Function<T, V> valueSelector) {
		return Collections.emptyMap();
	}

	@Override
	public <R> Sequence<R> map(Function<T, R> mapper) {
		return instance();
	}

	@Override
	public <R> Sequence<R> flatMap(Function<T, Iterable<R>> mapper) {
		return instance();
	}

	@Override
	public Sequence<T> filter(Predicate<T> predicate) {
		return instance();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public Optional<T> findAny() {
		return Optional.empty();
	}

	@Override
	public Optional<T> findFirst() {
		return Optional.empty();
	}

}
