package com.example.bookslibrary.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity = Book.class, fetch = FetchType.EAGER)
    private List<Book> favoriteBooks;

    @Column(name = "role")
    private Role role;

    public Person() {
        favoriteBooks = new ArrayList<>();
    }



    public void updatePerson(Person person){
        if (person.getLogin()!=null){
            this.login = person.getLogin();
        }
        if (person.getPassword()!=null){
            this.password= person.getPassword();
        }
        if (person.getRole()!=null){
            this.role=person.getRole();
        }
    }

    public void addBook(Book book){
        favoriteBooks.add(book);
    }
    public void deleteBook(Book book){
        favoriteBooks.remove(book);
    }
}
