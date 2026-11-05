package com.tecsup.minishop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Convierte las excepciones en respuestas HTTP.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Los datos inválidos generan una respuesta HTTP 400.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidProduct(
            IllegalArgumentException exception) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }

    // Mantiene la respuesta HTTP 500 esperada por la guía.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(
            RuntimeException exception) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}