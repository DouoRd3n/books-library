package com.example.bookslibrary.controller;

import com.example.bookslibrary.model.Book;
import com.example.bookslibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer/books")
public class WriterController {

    @Autowired
    private BookService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Book book = service.getById(id);
        service.delete(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id){
        return service.getById(id);
    }
    @GetMapping
    public List<Book> getAll(){
        return service.getAll();
    }

    @PostMapping("/create")
    public Book create(@RequestBody Book book){
        return service.create(book);
    }

    @PatchMapping("/{id}")
    public Book update(@PathVariable int id,@RequestBody Book book){
        Book byId = service.getById(id);
        byId.update(book);
        return service.save(byId);
    }
}
