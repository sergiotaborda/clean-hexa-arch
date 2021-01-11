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
import com.github.reference.interaction.resources.BookResource;
import com.github.reference.application.services.BookApplicationService;
import com.github.reference.application.model.Book;
import com.github.reference.application.model.BookKey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("Enables basic and batch operations for Books.")
@RestController()
public class BookController {

	private final BookApplicationService applicationService;
	private final ConversionService conversionService;

	public BookController(
		BookApplicationService applicationService,
		ConversionService conversionService
	) {
		this.applicationService = applicationService;
		this.conversionService = conversionService;
	}

	@ApiOperation("Retrieves all Books")
	@GetMapping("api/books")
	public List<? extends BookResource> findAll (){
		return conversionService.convertAll(BookResource.class, applicationService.findAll());
	}

	@ApiOperation("Retrieves the Book that matches the key")
	@GetMapping("api/book/{key}")
	public BookResource findByKey (@PathVariable(name="key") String key){
		return applicationService.findByKey(new BookKey(key))
				.map(it -> conversionService.convertTo(BookResource.class, it))
				.orElseThrow(() -> new NotFoundException());
	}

	@ApiOperation("Add a Book")
	@PostMapping("api/book")
	public BookResource addNew (@RequestBody BookResource book){
		return conversionService.convertTo(BookResource.class, applicationService.save(conversionService.convertTo(Book.class, book)));
	}

	@ApiOperation("Add several Books in batch. If key is present, they are edited")
	@PostMapping("api/books")
	public List<? extends BookResource> addMany (@RequestBody List<BookResource> books){
		return conversionService.convertAll(BookResource.class, applicationService.saveAll(conversionService.convertAll(Book.class, books)));
	}

	@ApiOperation("Deletes the Book that matches the key")
	@DeleteMapping("api/book/{key}")
	public void delete (@PathVariable(name="key") String key){
		applicationService.deleteByKey(new BookKey(key));
	}

	@ApiOperation("Deletes all Books given the keys")
	@DeleteMapping("api/books/{keys}")
	public void deleteMany (@ApiParam("A comma separated list of keys to delete") @PathVariable(name="keys") String keys){
		applicationService.deleteAllByKeys(Transformations.split(keys, ",").map(key -> new BookKey(key)).asSet());
	}
}
