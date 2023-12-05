package com.simform.controller;

import com.simform.entity.Person;
import com.simform.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> getAllPersons() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        service.addPerson(person);
        BodyBuilder response = ResponseEntity.status(HttpStatus.CREATED);
        return response.build();
    }
}
