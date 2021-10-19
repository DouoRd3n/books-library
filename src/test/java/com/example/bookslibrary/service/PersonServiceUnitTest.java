package com.example.bookslibrary.service;

import com.example.bookslibrary.model.Person;
import com.example.bookslibrary.repository.PersonRepository;
import org.apache.tomcat.util.compat.JrePlatform;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.bookslibrary.PersonTestDara.person;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class PersonServiceUnitTest {

    @Mock
    private PersonRepository repository;


    private PersonService service = new PersonService(repository);

//    @Before
//    void init(){
//        service = new PersonService(repository);
//    }

    @Test
   void getById() {
        when(repository.save(person)).thenReturn(person);
        Person save = service.save(person);
        assertThat(save).usingRecursiveComparison().isEqualTo(person);

    }
}
