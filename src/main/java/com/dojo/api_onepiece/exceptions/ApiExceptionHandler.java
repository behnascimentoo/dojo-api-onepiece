package com.dojo.api_onepiece.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValid(HttpServletRequest servletRequest, MethodArgumentNotValidException ex){
        var messageError = new ErrorMessage(servletRequest, HttpStatus.UNPROCESSABLE_ENTITY, "campos invalidos!", ex.getBindingResult());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(messageError);
    }

    @ExceptionHandler(PirateNotFoundException.class)
    public ResponseEntity<ErrorMessage> pirateNotFound(HttpServletRequest servletRequest, PirateNotFoundException ex){
        var messageError = new ErrorMessage(servletRequest, HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status((HttpStatus.NOT_FOUND))
                .contentType(MediaType.APPLICATION_JSON)
                .body(messageError);
    }

    @ExceptionHandler(MissionNotFoundException.class)
    public ResponseEntity<ErrorMessage> missionNotFound(HttpServletRequest servletRequest, MissionNotFoundException ex){
        var messageError = new ErrorMessage(servletRequest, HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status((HttpStatus.NOT_FOUND))
                .contentType(MediaType.APPLICATION_JSON)
                .body(messageError);
    }
}
