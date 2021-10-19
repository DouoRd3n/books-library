package com.example.bookslibrary;

import com.example.bookslibrary.model.Person;
import com.example.bookslibrary.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BooksLibraryApplication.class)
class BooksLibraryApplicationTests {

	@Autowired
	private PersonService personService;




}
