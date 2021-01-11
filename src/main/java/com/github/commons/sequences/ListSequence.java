package com.github.commons.sequences;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListSequence<T> implements Sequence<T> {

	private final List<T> list;

	ListSequence(List<T> list){
		this.list = list;
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public <R> Sequence<R> map(Function<T, R> mapper) {
		return new ListSequence<R>(list.stream().map(mapper).collect(Collectors.toList()));
	}

	@Override
	public <R> Sequence<R> flatMap(Function<T, Iterable<R>> mapper) {
		return new ListSequence<R>(list.stream().flatMap(it -> StreamSupport.stream(mapper.apply(it).spliterator(), false)).collect(Collectors.toList()));
	}

	@Override
	public Sequence<T> filter(Predicate<T> predicate) {
		return new ListSequence<T>(list.stream().filter(predicate).collect(Collectors.toList()));
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Optional<T> findAny() {
		return findFirst();
	}

	@Override
	public Optional<T> findFirst() {
		if (list.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.ofNullable(list.get(0));
		}
	}

}
