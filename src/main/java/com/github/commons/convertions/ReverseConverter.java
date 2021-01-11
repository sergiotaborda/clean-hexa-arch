package com.github.commons.convertions;

public final class ReverseConverter<T, S> implements Converter<T,S> {

	
	private final Converter<S, T> original;

	public ReverseConverter(Converter<S, T> original) {
		this.original = original;
	}

	@Override
	public Class<T> getSourceType() {
		return original.getTargetType();
	}

	@Override
	public Class<S> getTargetType() {
		return original.getSourceType();
	}

	@Override
	public S convertTo(ConversionContext context , T source) {
		return original.convertFrom(context,source);
	}

	@Override
	public T convertFrom(ConversionContext context, S target) {
		return original.convertTo(context, target);
	}
	
	

}
