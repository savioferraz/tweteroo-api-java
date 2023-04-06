package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetsServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetsServices services;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createTweet(@RequestBody @Valid TweetDTO req) {
        services.createTweet(req);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tweet> getAllTweets() {
        return services.getAllTweets();
    }

    @GetMapping("/user/{username}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tweet> getUserTweets(@PathVariable String username) {
        return services.getUserTweets(username);
    }

    @GetMapping(params = "page")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Tweet> getTweetByPage(@RequestParam int page) {
        return services.getTweetsByPage(page);
    }
}
