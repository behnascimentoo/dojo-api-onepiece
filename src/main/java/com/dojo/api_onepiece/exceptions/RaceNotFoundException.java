package com.dojo.api_onepiece.exceptions;

import com.dojo.api_onepiece.entity.RacePirate;

public class RaceNotFoundException extends RuntimeException {
    public RaceNotFoundException(String message) {
        super(message);
    }

    public static PirateNotFoundException byRace(RacePirate racePirate){
        return new PirateNotFoundException("Pirata não encontrado pela raça: " + racePirate);
    }
}
