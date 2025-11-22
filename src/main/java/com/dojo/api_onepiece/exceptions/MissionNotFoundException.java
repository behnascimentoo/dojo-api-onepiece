package com.dojo.api_onepiece.exceptions;

public class MissionNotFoundException extends RuntimeException {
    public MissionNotFoundException(String message) {
        super(message);
    }

    public static MissionNotFoundException byId(Long id){
        return new MissionNotFoundException("Missão não encontrada pelo id: " + id);
    }

}
