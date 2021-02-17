package no.gretkas.ov2;

import no.gretkas.ov2.controller.AuthorController;
import no.gretkas.ov2.controller.BookController;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Ov2ApplicationTests {

	@Autowired
	AuthorController authorController;
	@Autowired
	BookController bookController;

	@Test
	void contextLoadsAuthor() {
		Assertions.assertNotNull(authorController);
	}
	@Test
	void contextLoadsBook() {
		Assertions.assertNotNull(bookController);
	}

}
