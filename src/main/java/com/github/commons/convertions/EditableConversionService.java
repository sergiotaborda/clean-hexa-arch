package com.github.commons.convertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.commons.keys.EntityKeyConverter;
import com.github.commons.keys.KeyStringConverter;
import com.github.commons.sequences.Sequence;

public class EditableConversionService implements ConversionService , ConvertersRegistry {

	@SuppressWarnings("rawtypes")
	Map<ConversionKey, Converter> converters = new HashMap<>();

	public EditableConversionService () {
		add(new KeyStringConverter());
		add(new EntityKeyConverter());
	}
	
	public <S,T> EditableConversionService add(Converter<S,T> converter) {

		converters.put(new ConversionKey(converter.getSourceType(), converter.getTargetType()), converter);
		converters.put(new ConversionKey(converter.getTargetType(), converter.getSourceType()), converter.revert());

		return this;
	}


	@Override
	public <T> T convertTo(Class<T> type, Object source) {
		return new ConversionContext(this.converters,null, type).convertTo(type, source);
	}


	@Override
	public <T> List<T> convertAll(Class<T> type,List<?> all) {

		return new ConversionContext(this.converters, null,type).convertAll(type, all);
	}

	@Override
	public <T> Sequence<T> convertAll(Class<T> type,Sequence<?> all) {
		return new ConversionContext(this.converters, null, type).convertAll(type, all);
	}

}
