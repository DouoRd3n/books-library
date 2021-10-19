package com.example.bookslibrary.repository;

import com.example.bookslibrary.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {


   Optional<Person> findByLogin(String Login);




}
