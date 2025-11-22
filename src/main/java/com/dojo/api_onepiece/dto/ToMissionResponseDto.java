package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.DangerLevel;
import com.dojo.api_onepiece.entity.StatusMission;
import com.dojo.api_onepiece.entity.TypeOfMission;

public record ToMissionResponseDto(

        DangerLevel dangerLevel,
        TypeOfMission typeOfMission,
        StatusMission statusMission
) {}
