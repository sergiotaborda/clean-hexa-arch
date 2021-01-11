package com.github.commons.keys;

public final class EntityKey<T> extends Key{

	public static <X> EntityKey<X> ofIdentifier(Class<X> type, Object identifier) {
		if (identifier == null) {
			throw new IllegalArgumentException("Identifier is required");
		}
		return new EntityKey<X>(type.getSimpleName() + "::" + identifier.toString());
	}



	protected EntityKey(String identifier) {
		super(identifier);
	}


	public Long getLongIdentifier() {
		String[] parts = value.split("::");
		if(parts.length != 2){
			throw new IllegalStateException("Invalid key");
		}
		
		String id = parts[1];
		
		return Long.parseLong(id);
	}

}
