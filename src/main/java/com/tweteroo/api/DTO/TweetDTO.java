package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetDTO(

        @NotBlank int personId,

        @NotBlank @Size(max = 300) String tweet) {

}
