package com.github.commons.keys;

public abstract class Key {

	protected final String value;
	
	protected Key(String value) {
		if(value == null) {
			throw new IllegalArgumentException("Key value cannot be null");
		}
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
	
	public int hashCode() {
		return this.value.hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Key && equals((Key)other);
	}
	
	public boolean equals(Key other) {
		return other != null &&  this.value.equals(other.value);
	}

	public <T> EntityKey<T> ofEntity(Class<T> t) {
		return new EntityKey<T>(this.value);
	}

}
