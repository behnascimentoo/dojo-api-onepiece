package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.CrewPirate;
import jakarta.validation.constraints.NotBlank;

public record CreatePirateDto(

        @NotBlank(message = "O nome não pode estar em branco")
        String name,

        @NotBlank(message = "A raça não pode estar em branco")
        String race,

        @NotBlank(message = "A tripulação não pode estar em branco")
        CrewPirate crew
) {}
