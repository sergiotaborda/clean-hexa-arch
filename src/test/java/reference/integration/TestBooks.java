package reference.integration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.reference.interaction.resources.BookResource;
import com.github.reference.interaction.rest.BookController;
import com.github.reference.start.Application;


@SpringBootTest(classes = Application.class)
class TestBooks {

	@Autowired
	public BookController BookController;

	List<BookResource> books(){
		
		var a = new BookResource();
		a.setName("A");
		
		var b = new BookResource();
		b.setName("B");
		
		var c = new BookResource();
		c.setName("C");
		
		return List.of(a,b,c);
	}
	
	@Test
	void testBookCreation() {
		assertNotNull(this.BookController);
		
		var result = this.BookController.addMany(books());
		
		assertNotNull(result);
		assertEquals(3,result.size());
		
		assertNotNull(result.get(0).getKey());
	}

	
	
}
