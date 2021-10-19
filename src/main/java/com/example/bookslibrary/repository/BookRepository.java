package com.example.bookslibrary.repository;

import com.example.bookslibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByTitle(String title);
}
