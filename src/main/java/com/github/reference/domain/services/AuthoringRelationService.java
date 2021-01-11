package com.github.reference.domain.services;

import java.util.List;
import java.util.Set;

import com.github.commons.sequences.Sequence;
import com.github.commons.keys.EntityKey;
import com.github.reference.domain.model.AuthoringRelationEntity;

public interface AuthoringRelationService {

	public AuthoringRelationEntity save (AuthoringRelationEntity authoringRelation);
	public Sequence<AuthoringRelationEntity> saveAll (Sequence<AuthoringRelationEntity> authoringRelations);
	public void delete (AuthoringRelationEntity authoringRelation);
	public void deleteAll (Sequence<AuthoringRelationEntity> authoringRelations);
}
