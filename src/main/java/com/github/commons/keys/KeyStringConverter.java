package com.github.commons.keys;

import java.lang.reflect.InvocationTargetException;

import com.github.commons.convertions.AbstractConverter;
import com.github.commons.convertions.ConversionContext;
import com.github.commons.reflection.ReflectionException;

public class KeyStringConverter extends AbstractConverter<Key, String>  {

	
	@Override
	public String convertTo(ConversionContext context, Key source) {
		return source.value;
	}

	@Override
	public Key convertFrom(ConversionContext context, String target) {
		
		try {
			return Key.class.cast(context.getRequestedType().getConstructor(String.class).newInstance(target));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ReflectionException(e);
		}
	}

}
