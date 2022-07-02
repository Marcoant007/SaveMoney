package com.example.savemoney.services.exceptions;

public class ServiceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ServiceNotFoundException(String msng){
        super(msng);
    }
}
