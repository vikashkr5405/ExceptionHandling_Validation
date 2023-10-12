package com.vikash.ExceptionHandling_Validation;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class PersonController
{
    @Autowired
    PersonService pserv;

    @PostMapping
    public ResponseEntity<Person> saveUser(@Valid @RequestBody Person person)
    {
        Person p=pserv.saveDetails(person);
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll()
    {
        return ResponseEntity.ok(pserv.fetchAllUsers());
    }
}
