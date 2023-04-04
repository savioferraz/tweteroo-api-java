package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PersonDTO(

        @NotBlank(message = "Name must not be blank") @Size(min = 3, max = 50, message = "Enter a valid username") String username,

        @NotBlank(message = "Name must not be blank") String avatar

) {

}
