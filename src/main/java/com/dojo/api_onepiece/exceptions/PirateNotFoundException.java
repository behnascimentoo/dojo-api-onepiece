package com.dojo.api_onepiece.exceptions;

public class PirateNotFoundException extends RuntimeException {
  public PirateNotFoundException(String message) {
    super(message);
  }

  public static PirateNotFoundException byId(Long id){
    return new PirateNotFoundException("Raça não encontrada para o id: " + id);
  }

}
