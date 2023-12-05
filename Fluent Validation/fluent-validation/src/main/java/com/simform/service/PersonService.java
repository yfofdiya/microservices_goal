package com.simform.service;

import com.simform.entity.Person;
import com.simform.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person savePersonDetails(Person person) {
        return repository.save(person);
    }
}
