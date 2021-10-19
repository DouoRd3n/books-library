package com.example.bookslibrary.exeption;

public class BookNotFoundExeption extends RuntimeException{
    public BookNotFoundExeption(int id) {
        super("book by id " + id + " not found");
    }

    public BookNotFoundExeption(String title) {
        super("book by title " + title + " not found");
    }
}
