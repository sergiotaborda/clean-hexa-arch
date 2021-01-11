package com.github.reference.application.services;

import java.util.List;
import java.util.Set;
import java.util.Optional;

import com.github.reference.application.model.AuthoringRelation;
import com.github.reference.application.model.AuthoringRelationKey;

public interface AuthoringRelationApplicationService {

	public AuthoringRelation save (AuthoringRelation authoringRelation);
	public void deleteByKey (AuthoringRelationKey key);
}
