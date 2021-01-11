package com.github.commons.sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Sequence<T> extends Iterable<T> {

	public static <X> Sequence<X> empty(){
		return EmptySequence.instance();
	}

	@SafeVarargs
	public static <X> Sequence<X> of(X ... others){
		if (others.length == 0) {
			return empty();
		}
		
		return new ListSequence<X>(Arrays.asList(others));
	}
	
	public static <X> Sequence<X> of(Collection<X> other){
		if ( other instanceof List) {
			return new ListSequence<X>((List<X>) other);
		}
		return new ListSequence<X>(new ArrayList<>(other));
	}
	
	public <R> Sequence<R> map(Function<T,R> mapper);
	
	public <R> Sequence<R> flatMap(Function<T,Iterable<R>> mapper);
	
	public Sequence<T> filter(Predicate<T> predicate);
	
	public default Set<T> asSet() {
		var set = new HashSet<T>();
		for(T item : this) {
			set.add(item);
		}
		return set;
	}
	
	public default List<T> asList() {
		var list = new LinkedList<T>();
		for(T item : this) {
			list.add(item);
		}
		return list;
	}
	
	public default <K> Map<K,T> asMap(Function<T,K> keySelector) {
		var map = new HashMap<K,T>();
		for(T item : this) {
			map.put(keySelector.apply(item), item);
		}
		return map;
	}
	
	public default <K,V> Map<K,V> asMap(Function<T,K> keySelector,Function<T,V> valueSelector){
		var map = new HashMap<K,V>();
		for(T item : this) {
			map.put(keySelector.apply(item), valueSelector.apply(item));
		}
		return map;
	}

	public boolean isEmpty();

	public Optional<T> findAny();

	public Optional<T> findFirst();
}
