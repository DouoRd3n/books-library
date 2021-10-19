package com.example.bookslibrary.controller;

import com.example.bookslibrary.model.Person;
import com.example.bookslibrary.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/person")
public class AdminController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAll(){
        return personService
                .getAll();
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        return personService
                .getById(id);
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person){
        return personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Person byId = personService.getById(id);
        personService.delete(byId);
    }

    @PatchMapping("/{id}")
    public Person update(@PathVariable int id, @RequestBody Person person){
        Person byId = personService.getById(id);
        byId.updatePerson(person);
        return personService.save(byId);

    }
}
