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
        if (!verifyEmail(data.getEmail())) {
            System.out.println("Email already exist");
        }

        repository.save(data);
    }

    public void deletePerson(int id) {
        repository.deleteById(id);
    }

    public void updatePersonData(int id, PersonDTO data) {
        repository.findById(id).map(person -> {
            person.setEmail(data.email());
            person.setName(data.name());
            person.setAvatar(data.avatar());
            person.setPassword(data.password());
            return repository.save(person);
        });
    }

    private boolean verifyEmail(String email) {
        return repository.findByEmail(email) != null;
    }
}
