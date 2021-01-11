package com.github.reference.domain.services.actual;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.commons.sequences.Sequence;
import com.github.commons.convertions.ConversionService;
import com.github.reference.application.model.AuthoringRelation;
import com.github.reference.application.model.AuthoringRelationKey;
import com.github.reference.domain.model.AuthoringRelationEntity;
import com.github.reference.domain.services.AuthoringRelationService;
import com.github.reference.domain.repositories.AuthoringRelationRepository;

public class ActualAuthoringRelationService implements AuthoringRelationService {

	private final AuthoringRelationRepository repository;

	public ActualAuthoringRelationService(
		AuthoringRelationRepository repository
	) {
		this.repository = repository;
	}
	public AuthoringRelationEntity save (AuthoringRelationEntity authoringRelation){
		//TODO valiation
		return repository.save(authoringRelation);
	}
	public Sequence<AuthoringRelationEntity> saveAll (Sequence<AuthoringRelationEntity> authoringRelations){
		//TODO valiation
		return repository.saveAll(authoringRelations);
	}
	public void delete (AuthoringRelationEntity authoringRelation){
		//TODO valiation
		repository.deleteAll(Sequence.of(authoringRelation));
	}
	public void deleteAll (Sequence<AuthoringRelationEntity> authoringRelations){
		//TODO valiation
		repository.deleteAll(authoringRelations);
	}
}
