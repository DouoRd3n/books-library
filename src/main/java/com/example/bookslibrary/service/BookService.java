package com.example.bookslibrary.service;

import com.example.bookslibrary.exeption.BookNotFoundExeption;
import com.example.bookslibrary.model.Book;
import com.example.bookslibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    private BookRepository repository;

    public void delete(Book book){
        repository.delete(book);
    }

    public Book create(Book book){
        return repository.save(book);
    }

    public Book getById(int id){
        return repository.findById(id)
                .orElseThrow(()->new BookNotFoundExeption(id));
    }

    public Book getByTitle(String title){
        return repository
                .findByTitle(title)
                .orElseThrow(()->new BookNotFoundExeption(title));
    }

    public Book save(Book book){
        return repository.save(book);
    };

    public List<Book> getAll(){
        return repository.findAll(Sort.by("title"));
    }
}
