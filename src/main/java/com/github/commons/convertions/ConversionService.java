package com.github.commons.convertions;

import java.util.List;

import com.github.commons.sequences.Sequence;

public interface ConversionService {

	<T> T convertTo(Class<T> type, Object source);

	<T> List<T> convertAll(Class<T> type, List<?> all);

	<T> Sequence<T> convertAll(Class<T> type, Sequence<?> all);

}