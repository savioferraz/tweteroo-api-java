package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.PersonDTO;
import com.tweteroo.api.models.Person;
import com.tweteroo.api.services.PersonsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class PersonsController {

    @Autowired
    private PersonsService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createPerson(@RequestBody @Valid PersonDTO req) {
        service.createPerson(new Person(req));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable int id) {
        service.deletePerson(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updatePersonData(@PathVariable int id, @RequestBody @Valid PersonDTO req) {
        service.updatePersonData(id, req);
    }
}
