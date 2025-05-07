package com.juliock.SpringPro_Session3_Exercicio.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class InvalidFieldConstraintError extends CustomError{

    private List<InvalidFieldMessage> errorMessageList = new ArrayList<>();

    public InvalidFieldConstraintError(Instant instant, Integer statusCode, String errorMessage, String path) {
        super(instant, statusCode, errorMessage, path);
    }

    public List<InvalidFieldMessage> getErrorMessageList() {
        return errorMessageList;
    }

    public void addError(String fieldName, String errorMessage) {
        errorMessageList.add(new InvalidFieldMessage(fieldName, errorMessage));
    }
}
