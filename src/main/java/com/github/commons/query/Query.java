package com.github.commons.query;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.github.commons.sequences.Sequence;

public interface Query<T> {
	
	public static <X> Query<X> empty() {
		return EmptyQuery.instance();
	}

	public List<T> list();
	
	public default Sequence<T> sequence(){
		return Sequence.of(list());
	}

	public Optional<T> first();
	
	public default <R> Query<R> map(Function<T,R> transformation) {
		return new TransformationQuery<>(this, transformation);
	}

	
	

}
