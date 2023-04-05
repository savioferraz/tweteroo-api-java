package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.PersonDTO;
import com.tweteroo.api.models.Person;
import com.tweteroo.api.repositories.PersonsRepository;

@Service
public class PersonsService {

    @Autowired
    private PersonsRepository repository;

    public void createPerson(Person data) {
        if (verifyUserName(data.getUsername())) {
            System.err.println("Username already exist");
        }

        repository.save(data);
    }

    public void deletePerson(int id) {
        repository.deleteById(id);
    }

    public void updatePersonData(int id, PersonDTO data) {
        repository.findById(id).map(person -> {
            person.setUsername(data.username());
            person.setAvatar(data.avatar());
            return repository.save(person);
        });
    }

    private boolean verifyUserName(String username) {
        return repository.findByUsername(username) != null;
    }
}
