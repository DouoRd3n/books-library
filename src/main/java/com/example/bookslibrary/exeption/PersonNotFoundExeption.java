package com.example.bookslibrary.exeption;

public class PersonNotFoundExeption extends RuntimeException{

    public PersonNotFoundExeption(int message) {
        super("person with id " +message + " not found");
    }

    public PersonNotFoundExeption(String login) {
        super("person by login" + login + "not found");
    }
}
