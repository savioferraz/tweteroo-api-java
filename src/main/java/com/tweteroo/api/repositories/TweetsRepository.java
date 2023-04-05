package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.models.Tweet;

@Repository
public interface TweetsRepository extends JpaRepository<Tweet, Integer> {
    List<Tweet> findFirst10ByOrderByIdDesc();
}
