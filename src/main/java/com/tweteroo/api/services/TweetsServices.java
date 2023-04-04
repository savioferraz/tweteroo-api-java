package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetsRepository;

@Service
public class TweetsServices {

    @Autowired
    private TweetsRepository tweetsRepository;

    public void createTweet(Tweet data) {
        tweetsRepository.save(data);
    }

    public void deleteTweet(int id) {
        tweetsRepository.deleteById(id);
    }

    public List<Tweet> getAllTweets() {
        return tweetsRepository.findLast10Tweets();
    }

    public List<Tweet> getUserTweets(String username) {
        return tweetsRepository.findByPersonUsername(username);
    }

}
