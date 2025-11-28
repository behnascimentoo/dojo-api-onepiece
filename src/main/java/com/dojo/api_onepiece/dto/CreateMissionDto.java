package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.StatusMission;
import com.dojo.api_onepiece.entity.TypeOfMission;
import jakarta.validation.constraints.NotNull;

public record CreateMissionDto(

        @NotNull(message = "id do pirata precisa ser válido!")
        Long pirateId,

        @NotNull(message = "Nivel de perigo não pode estar em branco")
        DangerLevel dangerLevel,

        @NotNull(message = "Tipo da missão não pode estar em branco")
        TypeOfMission typeOfMission,

        @NotNull(message = "O status não pode esta vazio")
        StatusMission statusMission
) {}
