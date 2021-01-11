package com.github.reference.application.services.actual;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.commons.convertions.ConversionService;
import com.github.commons.sequences.Sequence;
import com.github.reference.application.model.AuthoringRelation;
import com.github.reference.application.model.AuthoringRelationKey;
import com.github.reference.domain.model.AuthoringRelationEntity;
import com.github.reference.application.services.AuthoringRelationApplicationService;
import com.github.reference.domain.services.AuthoringRelationService;
import com.github.reference.domain.repositories.AuthoringRelationRepository;

public class ActualAuthoringRelationApplicationService implements AuthoringRelationApplicationService {

	private final AuthoringRelationService domainService;
	private final AuthoringRelationRepository repository;
	private final ConversionService conversionService;

	public ActualAuthoringRelationApplicationService(
		AuthoringRelationService domainService,
		AuthoringRelationRepository repository,
		ConversionService conversionService
	) {
		this.repository = repository;
		this.domainService = domainService;
		this.conversionService = conversionService;
	}
	public AuthoringRelation save (AuthoringRelation authoringRelation){
		return conversionService.convertTo(AuthoringRelation.class,domainService.save(conversionService.convertTo(AuthoringRelationEntity.class, authoringRelation)));
	}
	public void deleteByKey (AuthoringRelationKey key){
		repository.findByKey(key.ofEntity(AuthoringRelationEntity.class)).ifPresent( instance -> domainService.delete(instance));
	}
}
