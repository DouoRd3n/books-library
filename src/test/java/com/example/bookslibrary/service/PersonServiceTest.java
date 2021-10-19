package com.example.bookslibrary.service;



import com.example.bookslibrary.exeption.PersonNotFoundExeption;
import com.example.bookslibrary.model.Person;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static com.example.bookslibrary.PersonTestDara.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:db/populateDB.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PersonServiceTest {

    @Autowired
    private PersonService service;

//    @BeforeClass
//    @Transactional
//    void setUp() {
//
//        service.save(person);
//        service.save(person2);
//        service.save(person3);
//
//    }


    @Test
    void getById() {
        service.save(person);
        assertThat(service.getById(person.getId()))
                .usingRecursiveComparison()
                .ignoringFields("favoriteBooks")
                .isEqualTo(person);

    }

    @Test
    void getByLogin() {
        Person byLogin = service.getByLogin(person.getLogin());
        assertThat(byLogin).usingRecursiveComparison()
                .isEqualTo(person);
    }

    @Test
    void getAll() {
        assertThat(service.getAll())
                        .usingRecursiveComparison()
                        .isEqualTo(list);

    }

    @Test
    @Transactional
    void create() {
        service.save(person);
        assertThat(service.getById(person.getId()))
                .usingRecursiveComparison()
                .isEqualTo(person);
    }
    @Test
    @Transactional
    void update(){
        Person updetePerson = service.getById(1);
        updetePerson.setPassword("newPassword");
        service.save(updetePerson);
        assertThat(updetePerson)
                .usingRecursiveComparison()
                .isEqualTo(service.getById(updetePerson.getId()));

    }

    @Test
    @Transactional
    void delete(){
        service.delete(person3);
        assertThrows(PersonNotFoundExeption.class,()->service.getById(person3.getId()));
    }
}