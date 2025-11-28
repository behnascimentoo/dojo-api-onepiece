package com.dojo.api_onepiece.dto;

import com.dojo.api_onepiece.entity.RacePirate;
import com.dojo.api_onepiece.entity.StatusPirate;

public record PirateResponseDto(

        Long id,
        String name,
        RacePirate racePirate,
        String crewPirate,
        StatusPirate statusPirate

) {
}
