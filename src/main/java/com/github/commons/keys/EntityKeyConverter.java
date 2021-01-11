package com.github.commons.keys;

import java.lang.reflect.InvocationTargetException;

import com.github.commons.convertions.AbstractConverter;
import com.github.commons.convertions.ConversionContext;
import com.github.commons.reflection.ReflectionException;

@SuppressWarnings("rawtypes")
public class EntityKeyConverter extends AbstractConverter< EntityKey, Key>  {

	@Override
	public Key convertTo(ConversionContext context, EntityKey source) {
		try {
			return Key.class.cast(context.getRequestedType().getConstructor(String.class).newInstance(source.value));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new ReflectionException(e);
		}
	}

	@Override
	public EntityKey convertFrom(ConversionContext context, Key target) {
		return target.ofEntity(context.getParentType());
	}

	

}
