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
import com.github.reference.interaction.resources.AuthorResource;
import com.github.reference.application.services.AuthorApplicationService;
import com.github.reference.application.model.Author;
import com.github.reference.application.model.AuthorKey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Enables basic and batch operations for Authors.")
@RestController()
public class AuthorController {

	private final AuthorApplicationService applicationService;
	private final ConversionService conversionService;

	public AuthorController(
		AuthorApplicationService applicationService,
		ConversionService conversionService
	) {
		this.applicationService = applicationService;
		this.conversionService = conversionService;
	}

	@ApiOperation("Retrieves all Authors")
	@GetMapping("api/authors")
	public List<? extends AuthorResource> findAll (){
		return conversionService.convertAll(AuthorResource.class, applicationService.findAll());
	}

	@ApiOperation("Retrieves the Author that matches the key")
	@GetMapping("api/author/{key}")
	public AuthorResource findByKey (@PathVariable(name="key") String key){
		return applicationService.findByKey(new AuthorKey(key))
				.map(it -> conversionService.convertTo(AuthorResource.class, it))
				.orElseThrow(() -> new NotFoundException());
	}

	@ApiOperation("Add a Author")
	@PostMapping("api/author")
	public AuthorResource addNew (@RequestBody AuthorResource author){
		return conversionService.convertTo(AuthorResource.class, applicationService.save(conversionService.convertTo(Author.class, author)));
	}

	@ApiOperation("Add several Authors in batch. If key is present, they are edited")
	@PostMapping("api/authors")
	public List<? extends AuthorResource> addMany (@RequestBody List<AuthorResource> authors){
		return conversionService.convertAll(AuthorResource.class, applicationService.saveAll(conversionService.convertAll(Author.class, authors)));
	}

	@ApiOperation("Deletes the Author that matches the key")
	@DeleteMapping("api/author/{key}")
	public void delete (@PathVariable(name="key") String key){
		applicationService.deleteByKey(new AuthorKey(key));
	}

	@ApiOperation("Deletes all Authors given the keys")
	@DeleteMapping("api/authors/{keys}")
	public void deleteMany (@ApiParam("A comma separated list of keys to delete") @PathVariable(name="keys") String keys){
		applicationService.deleteAllByKeys(Transformations.split(keys, ",").map(key -> new AuthorKey(key)).asSet());
	}
}
