package com.tweteroo.api.models;

import java.util.ArrayList;
import java.util.List;

import com.tweteroo.api.DTO.PersonDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Person {

    public Person(PersonDTO req) {
        this.username = req.username();
        this.avatar = req.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;

    @OneToMany(mappedBy = "person")
    private List<Tweet> tweets = new ArrayList<>();
}
