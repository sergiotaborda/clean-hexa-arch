package com.github.reference.start.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.commons.convertions.ConversionService;
import com.github.commons.convertions.EditableConversionService;
import com.github.reference.application.converters.AuthorConverter;
import com.github.reference.application.converters.AuthoringRelationConverter;
import com.github.reference.application.converters.BookConverter;
import com.github.reference.interaction.converters.AuthorResourceConverter;
import com.github.reference.interaction.converters.AuthoringRelationResourceConverter;
import com.github.reference.interaction.converters.BookResourceConverter;

@Configuration
public class ConvertionConfiguration {

	
	@Bean
	public ConversionService configconversionService() {
		// Register all needed converters
		var registry = new EditableConversionService()
		.add(new AuthorResourceConverter())
		.add(new AuthorConverter())
		.add(new BookConverter())
		.add(new BookResourceConverter())
		.add(new AuthoringRelationConverter())
		.add(new AuthoringRelationResourceConverter());
		
		return registry;
	}
	
}
