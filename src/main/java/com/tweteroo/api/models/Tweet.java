package com.tweteroo.api.models;

import com.tweteroo.api.DTO.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {

    public Tweet(TweetDTO req) {
        this.person = new Person(req.person());
        this.tweet = req.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(nullable = false)
    private String tweet;
}
