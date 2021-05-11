package com.endava.wishlistservice.service.advice;

import com.endava.wishlistservice.exception.InvalidValueException;
import com.endava.wishlistservice.exception.WishListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidValueException.class)
    public ResponseEntity<ErrorResponse> handleInvalid(InvalidValueException e) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ErrorResponse
                        .builder()
                        .message(e.getMessage())
                        .status(BAD_REQUEST.value())
                        .build());
    }

    @ExceptionHandler(WishListNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInvalid(WishListNotFoundException e) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(ErrorResponse
                        .builder()
                        .message(e.getMessage())
                        .status(NOT_FOUND.value())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }
}
