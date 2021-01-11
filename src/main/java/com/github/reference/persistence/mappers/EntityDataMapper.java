package com.github.reference.persistence.mappers;

public interface EntityDataMapper<E,D , C extends EntityDataMapperContext<E> > {

	public D toData(C context, E entity);
	public E fromData(C context, D data);
}
