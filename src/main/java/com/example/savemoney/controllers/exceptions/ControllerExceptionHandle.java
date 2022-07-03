package com.example.savemoney.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.example.savemoney.services.exceptions.ServiceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandle {
    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ServiceNotFoundException exception, HttpServletRequest request){
        StandardError standardError = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;
        standardError.setTimestamp(Instant.now());
        standardError.setMessage(exception.getMessage());
        standardError.setStatus(status.value());
        standardError.setPath(request.getRequestURI());
        standardError.setError("Service not Found");
        return ResponseEntity.status(status).body(standardError);
    }
    
}
