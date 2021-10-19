package com.example.bookslibrary.service;

import com.example.bookslibrary.exeption.PersonNotFoundExeption;
import com.example.bookslibrary.model.Person;
import com.example.bookslibrary.model.Role;
import com.example.bookslibrary.repository.PersonRepository;
import lombok.Data;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;

@Component
public class PersonService implements UserDetailsService {



    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Person getById(int id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundExeption(id));
    }

    public Person getByLogin(String login) {
        return personRepository
                .findByLogin(login)
                .orElseThrow(() -> new PersonNotFoundExeption(login));
    }


    public List<Person> getAll() {
        return personRepository
                .findAll(Sort.by("login"));
    }

    public Person save(Person person) {

        return personRepository
                .save(person);


    }

    public void delete(Person person){
        personRepository.delete(person);
    }

    public void deleteAll(){
        personRepository.deleteAll();
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person p = personRepository
                .findByLogin(login)
                .orElseThrow(()->new PersonNotFoundExeption(String.format("User %s is not found", login)));

        return new org.springframework.security.core.userdetails.User(p.getLogin(), p.getPassword(), true, true, true, true, new HashSet<>());

    }
}
