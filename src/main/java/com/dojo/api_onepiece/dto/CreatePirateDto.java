package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.entity.StatusPirate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePirateDto(

        @NotBlank(message = "O nome não pode estar em branco")
        String name,

        @NotNull(message = "A raça não pode estar em branco")
        RacePirate race,

        @NotBlank(message = "A tripulação não pode estar em branco")
        String crew,

        @NotNull(message = "O Status não pode estar vazio")
        StatusPirate statusPirate
) {}
