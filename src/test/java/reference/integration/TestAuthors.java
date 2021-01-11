package reference.integration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.reference.interaction.resources.AuthorResource;
import com.github.reference.interaction.rest.AuthorController;
import com.github.reference.start.Application;


@SpringBootTest(classes = Application.class)
class TestAuthors {

	@Autowired
	public AuthorController AuthorController;
	
	
	static List<AuthorResource> authors(){
		
		var labA = new AuthorResource();
		labA.setName("A");
		
		var labB = new AuthorResource();
		labB.setName("B");
		
		var labC = new AuthorResource();
		labC.setName("C");
		
		return List.of(labA,labB,labC);
	}
	
	@Test
	void testAuthorCreation() {
		assertNotNull(this.AuthorController);
		
		var result = this.AuthorController.addMany(authors());
		
		assertNotNull(result);
		assertEquals(3,result.size());
		
		assertNotNull(result.get(0).getKey());
	}

	
	
}
