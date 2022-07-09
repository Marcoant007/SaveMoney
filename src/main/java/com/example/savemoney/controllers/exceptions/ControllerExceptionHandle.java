package com.example.savemoney.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.savemoney.services.exceptions.DatabaseException;
import com.example.savemoney.services.exceptions.ServiceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandle {
   
    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ServiceNotFoundException exception, HttpServletRequest request){
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException exception, HttpServletRequest request){
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database exception ");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException exception, HttpServletRequest request){
        ValidationError error = new ValidationError();
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Validation exception");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
    
        for(FieldError field :  exception.getBindingResult().getFieldErrors()){
            error.addError(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(error);
    }

    // @ExceptionHandler(AmazonServiceException.class)
    // public ResponseEntity<StandardError> amazonService(AmazonServiceException exception, HttpServletRequest request){
    //     StandardError error = new StandardError();
    //     HttpStatus status = HttpStatus.BAD_REQUEST;
    //     error.setTimestamp(Instant.now());
    //     error.setStatus(status.value());
    //     error.setError("Aws Exception");
    //     error.setMessage(exception.getMessage());
    //     error.setPath(request.getRequestURI());
    //     return ResponseEntity.status(status).body(error);
    // }

    // @ExceptionHandler(AmazonClientException.class)
    // public ResponseEntity<StandardError> amazonClient(AmazonClientException exception, HttpServletRequest request){
    //     StandardError error = new StandardError();
    //     HttpStatus status = HttpStatus.BAD_REQUEST;
    //     error.setTimestamp(Instant.now());
    //     error.setStatus(status.value());
    //     error.setError("Aws Client Exception");
    //     error.setMessage(exception.getMessage());
    //     error.setPath(request.getRequestURI());
    //     return ResponseEntity.status(status).body(error);
    // }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> ilegalArgument(IllegalArgumentException exception, HttpServletRequest request){
        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Ilegal Argument Exception");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
    
}
