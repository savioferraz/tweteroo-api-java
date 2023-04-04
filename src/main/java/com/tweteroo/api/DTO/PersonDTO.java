package com.tweteroo.api.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PersonDTO(

                @NotBlank(message = "Name must not be blank") @Size(min = 4, max = 50, message = "Enter a valid email") @Email String email,

                @NotBlank(message = "Name must not be blank") @Size(min = 3, max = 50, message = "Enter a valid name") String name,

                @NotBlank(message = "Name must not be blank") String avatar,

                @NotBlank(message = "Name must not be blank") String password) {

}
