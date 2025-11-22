package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.CrewPirate;
import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.entity.StatusPirate;

public record UpdatePirateDto(

        String name,
        RacePirate racePirate,
        CrewPirate crewPirate,
        StatusPirate statusPirate

) {}
