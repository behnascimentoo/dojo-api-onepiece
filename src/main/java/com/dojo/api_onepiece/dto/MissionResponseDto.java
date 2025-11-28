package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.StatusMission;
import com.dojo.api_onepiece.entity.TypeOfMission;

public record MissionResponseDto(

        Long id,
        DangerLevel dangerLevel,
        TypeOfMission typeOfMission,
        StatusMission statusMission
) {}
