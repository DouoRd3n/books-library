package com.example.bookslibrary;

import com.example.bookslibrary.model.Book;
import com.example.bookslibrary.model.Person;
import com.example.bookslibrary.model.Role;

import java.util.ArrayList;
import java.util.List;

public class PersonTestDara {

    public static Person person = new Person();
    public static Person person2 = new Person();
    public static Person person3 = new Person();
    public static Book book1 = new Book();
    public static Book book2 = new Book();
    public static Book book3 = new Book();

    public static List<Person> list = new ArrayList<>();

    static {
        person.setId(1);
        person.setLogin("login1");
        person.setPassword("password1");
        person.setRole(Role.ADMIN);

        person2.setId(2);
        person2.setLogin("login2");
        person2.setPassword("password2");
        person2.setRole(Role.READER);

        person3.setId(3);
        person3.setLogin("login3");
        person3.setPassword("password3");
        person3.setRole(Role.WRITER);

        book1.setTitle("title1");
        book1.setAuthor("author1");
        book1.setId(1);
        book2.setTitle("title2");
        book2.setAuthor("author2");
        book2.setId(2);
        book3.setTitle("title3");
        book3.setAuthor("author3");
        book3.setId(3);

        person.addBook(book1);
        person.addBook(book2);
        person.addBook(book3);

        list.add(person);
        list.add(person2);
        list.add(person3);
    }

    public static Person getPerson() {
        return person;
    }

    public static List<Person> getAllPerson() {
        return list;
    }


}
