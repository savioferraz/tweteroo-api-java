package com.tweteroo.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.TweetDTO;
import com.tweteroo.api.models.Person;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.PersonsRepository;
import com.tweteroo.api.repositories.TweetsRepository;

@Service
public class TweetsServices {

    @Autowired
    private TweetsRepository tweetsRepository;

    @Autowired
    PersonsRepository personsRepository;

    public void createTweet(TweetDTO data) {
        Tweet tweet = new Tweet(data);

        Person person = personsRepository.findByUsername(data.username());

        tweet.setUsername(person.getUsername());

        tweetsRepository.save(tweet);
    }

    public void deleteTweet(int id) {
        tweetsRepository.deleteById(id);
    }

    public List<Tweet> getAllTweets() {
        return tweetsRepository.findFirst10ByOrderByIdDesc();
    }

    public List<Tweet> getUserTweets(String username) {
        List<Tweet> allTweets = tweetsRepository.findAll();
        List<Tweet> userTweets = new ArrayList<>();

        for (Tweet tweet : allTweets) {
            if (tweet.getUsername().equals(username)) {
                userTweets.add(tweet);
            }
        }
        return userTweets;
    }

    public List<Tweet> getTweetsByPage(int page) {
        PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());
        Page<Tweet> tweetPage = tweetsRepository.findAll(pageRequest);
        return tweetPage.getContent();
    }
}
