package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record SessionDTO(

        @NotBlank int personId,

        @NotBlank String token) {

}
