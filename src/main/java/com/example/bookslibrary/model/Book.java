package com.example.bookslibrary.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Data
@Table(name = "books")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "author")
    private String author;

    public void update(Book book){
        if (book.getTitle()!=null){
            this.title= book.title;
        }
        if (book.getAuthor()!=null){
            this.author= book.getAuthor();
        }

    }


}
