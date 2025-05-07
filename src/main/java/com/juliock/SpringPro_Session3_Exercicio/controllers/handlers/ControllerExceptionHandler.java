package com.juliock.SpringPro_Session3_Exercicio.controllers.handlers;

import com.juliock.SpringPro_Session3_Exercicio.dto.CustomError;
import com.juliock.SpringPro_Session3_Exercicio.dto.InvalidFieldConstraintError;
import com.juliock.SpringPro_Session3_Exercicio.services.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidFieldConstraintError> invalidField (MethodArgumentNotValidException e, HttpServletRequest request) {

        HttpStatus statusCode = HttpStatus.UNPROCESSABLE_ENTITY;
        InvalidFieldConstraintError validationErrors = new InvalidFieldConstraintError(Instant.now(), statusCode.value(), "Invalid field data", request.getRequestURI());

        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();

        for(FieldError f : fieldErrorList) {
            validationErrors.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(statusCode). body(validationErrors);
    }
}
