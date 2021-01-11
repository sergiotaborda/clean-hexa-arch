package reference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.github.commons.convertions.ConversionService;
import com.github.reference.application.model.Book;
import com.github.reference.domain.model.BookEntity;
import com.github.reference.interaction.converters.BookResourceConverter;
import com.github.reference.interaction.resources.AuthorResource;
import com.github.reference.interaction.resources.BookResource;
import com.github.reference.start.configuration.ConvertionConfiguration;

class TestConverters {

	BookResourceConverter converter  = new BookResourceConverter();

	ConversionService conversionService = new ConvertionConfiguration().configconversionService();
	
	@Test
	void testAutoTypeDiscover() {
		
		assertEquals(BookResource.class,converter.getSourceType());
		assertEquals(Book.class,converter.getTargetType());
	}
	
	
	@Test
	void testConvesionRoundtrip() {
		
		//given

		BookResource original = new BookResource();
		original.setKey("Key::1233456");
		original.setName("Name");
		original.setDescription("some good book");
		
		//when
		
		var target = conversionService.convertTo(Book.class, original);
		
		assertEquals(original.getName(), target.getName());
		
		var entity = conversionService.convertTo(BookEntity.class, target);
		
		assertEquals(original.getName(), entity.getName());
		
		var reversedTarget = conversionService.convertTo(Book.class, entity);
		
		assertEquals(target.getName(), reversedTarget.getName());
		
		var clone = conversionService.convertTo(BookResource.class, reversedTarget);
		
		// expected
		
		assertEquals(original.getName(), clone.getName());
		assertEquals(original.getKey(), clone.getKey());
		assertEquals(original.getDescription(), clone.getDescription());
	}
	


}
