package com.github.reference.interaction.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.commons.collections.Transformations;
import com.github.commons.convertions.ConversionService;
import com.github.reference.interaction.exceptions.NotFoundException;
import com.github.reference.interaction.resources.AuthoringRelationResource;
import com.github.reference.application.services.AuthoringRelationApplicationService;
import com.github.reference.application.model.AuthoringRelation;
import com.github.reference.application.model.AuthoringRelationKey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Enables basic and batch operations for AuthoringRelations.")
@RestController()
public class AuthoringRelationController {

	private final AuthoringRelationApplicationService applicationService;
	private final ConversionService conversionService;

	public AuthoringRelationController(
		AuthoringRelationApplicationService applicationService,
		ConversionService conversionService
	) {
		this.applicationService = applicationService;
		this.conversionService = conversionService;
	}

	@ApiOperation("Add a AuthoringRelation")
	@PostMapping("api/authoring-relation")
	public AuthoringRelationResource addNew (@RequestBody AuthoringRelationResource authoringRelation){
		return conversionService.convertTo(AuthoringRelationResource.class, applicationService.save(conversionService.convertTo(AuthoringRelation.class, authoringRelation)));
	}

	@ApiOperation("Deletes the AuthoringRelation that matches the key")
	@DeleteMapping("api/authoring-relation/{key}")
	public void delete (@PathVariable(name="key") String key){
		applicationService.deleteByKey(new AuthoringRelationKey(key));
	}
}
