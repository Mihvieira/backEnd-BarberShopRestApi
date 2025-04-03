package com.barbershop.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "Error: ";

    @ExceptionHandler(value = NoSuchFieldException.class)
    public ResponseEntity<String> handleNoSuchFieldException(NoSuchElementException ex) {
        return new ResponseEntity<>(DEFAULT_ERROR_VIEW + "Elemento não encontrado " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(DEFAULT_ERROR_VIEW + "Argumento inválido " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(DEFAULT_ERROR_VIEW + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
