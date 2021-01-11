package com.github.commons.convertions;

class ConversionKey {

	private final Class<?> sourceType;
	private final Class<?> targetType;

	public <S,T> ConversionKey(Class<S> sourceType, Class<T> targetType) {
		this.sourceType = sourceType;
		this.targetType = targetType;
	}

	@Override
	public boolean equals(Object other) {
		return  other instanceof ConversionKey && equals((ConversionKey)other);
	}
	
	public boolean equals(ConversionKey other) {
		return other != null 
				&& other.sourceType.getTypeName().equals(this.sourceType.getTypeName())
				&& other.targetType.getTypeName().equals(this.targetType.getTypeName());
	}
	
	@Override
	public int hashCode() {
		return this.sourceType.getTypeName().hashCode() + 31 * this.targetType.getTypeName().hashCode();
	}

	
	public boolean match(Class<?> source, Class<?> target) {
		
		
		return this.sourceType.isAssignableFrom(source) && this.targetType.isAssignableFrom(target);
		
	}
	
	
}
