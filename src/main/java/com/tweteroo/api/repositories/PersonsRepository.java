package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.Person;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Integer> {
    List<Person> findByEmail(String email);
}
