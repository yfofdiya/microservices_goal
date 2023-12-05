package com.simform.service;

import com.simform.entity.Person;
import com.simform.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public void addPerson(Person person) {
        repository.save(person);
    }

    public List<Person> getAll() {
        return repository.findAll();
    }
}
