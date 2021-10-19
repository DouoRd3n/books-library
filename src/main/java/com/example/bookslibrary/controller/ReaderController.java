package com.example.bookslibrary.controller;

import com.example.bookslibrary.model.Book;
import com.example.bookslibrary.model.Person;
import com.example.bookslibrary.service.BookService;
import com.example.bookslibrary.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reader/{id}")
public class ReaderController {

    @Autowired
    private PersonService personService;

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public List<Book> getFavoriteBooks(@PathVariable int id){
        return personService
                .getById(id)
                .getFavoriteBooks();
    }

    @PostMapping("/{id}")
    public void addBook(@PathVariable int personId,@RequestBody Book book){
        Person personById = personService.getById(personId);
        personById.addBook(book);
        personService.save(personById);

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int personId,@RequestBody Book book){
        Person person = personService.getById(personId);
        person.getFavoriteBooks()
                .remove(book);
    }
}
