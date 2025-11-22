package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.TypeOfMission;
import jakarta.validation.constraints.NotBlank;

public record CreateMissionDto(

        @NotBlank(message = "Nivel de perigo não pode estar em branco")
        DangerLevel dangerLevel,

        @NotBlank(message = "Tipo da missão não pode estar em branco")
        TypeOfMission typeOfMission
) {}
