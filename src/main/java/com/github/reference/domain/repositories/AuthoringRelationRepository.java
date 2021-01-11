package com.github.reference.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.github.reference.domain.model.AuthoringRelationEntity;
import com.github.commons.keys.EntityKey;
import com.github.commons.sequences.Sequence;

public interface AuthoringRelationRepository {

	public Sequence<AuthoringRelationEntity> findAll();
	public Optional<AuthoringRelationEntity> findByKey (EntityKey<AuthoringRelationEntity> key);
	public Sequence<AuthoringRelationEntity> findByKeys (Sequence<EntityKey<AuthoringRelationEntity>> keys);
	public AuthoringRelationEntity save (AuthoringRelationEntity authoringRelation);
	public Sequence<AuthoringRelationEntity> saveAll (Sequence<AuthoringRelationEntity> authoringRelation);
	public void deleteAll (Sequence<AuthoringRelationEntity> instances);
}
