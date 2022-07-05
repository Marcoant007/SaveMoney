package com.example.savemoney.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final Long serialVersioUID = 1L;

    private List<FieldMessage> erros = new ArrayList<>();

    public List<FieldMessage> getErrors(){
        return this.erros;
    }

    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
}
