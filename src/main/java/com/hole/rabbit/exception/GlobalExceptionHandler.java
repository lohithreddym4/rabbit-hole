package com.hole.rabbit.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConceptNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleConceptNotFound(ConceptNotFoundException ex) {
        return ex.getMessage();
    }
}
