package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetDTO(

                @NotBlank(message = "Username must not be blank") @Size(min = 3, max = 50, message = "Enter a valid username") String username,

                @NotBlank @Size(max = 300) String tweet) {
}
