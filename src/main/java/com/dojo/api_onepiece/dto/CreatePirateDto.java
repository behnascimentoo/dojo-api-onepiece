package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.RacePirate;
import jakarta.validation.constraints.NotBlank;

public record CreatePirateDto(

        @NotBlank(message = "O nome não pode estar em branco")
        String name,

        @NotBlank(message = "A raça não pode estar em branco")
        RacePirate race,

        @NotBlank(message = "A tripulação não pode estar em branco")
        String crew
) {}
