package com.vikash.ExceptionHandling_Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService
{
    @Autowired
    PersonRepository prepo;

    @Override
    public Person saveDetails(Person person) {
        return prepo.save(person);
    }

    @Override
    public List<Person> fetchAllUsers() {
        return prepo.findAll();
    }
}
