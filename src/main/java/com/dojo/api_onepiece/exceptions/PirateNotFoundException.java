package com.dojo.api_onepiece.exceptions;

import com.dojo.api_onepiece.entity.RacePirate;

public class PirateNotFoundException extends RuntimeException {
  public PirateNotFoundException(String message) {
    super(message);
  }

  public static PirateNotFoundException byId(Long id){
    return new PirateNotFoundException("Pirata não encontrado para o id: " + id);
  }

  public static PirateNotFoundException byRace(RacePirate racePirate){
    return new PirateNotFoundException("Pirata não encontrado pela raça: " + racePirate);
  }
}
