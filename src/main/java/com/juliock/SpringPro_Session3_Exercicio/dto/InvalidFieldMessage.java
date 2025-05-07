package com.juliock.SpringPro_Session3_Exercicio.dto;

public class InvalidFieldMessage {

    private final String fieldName;
    private final String violatedConstraint;

    public InvalidFieldMessage(String fieldName, String violatedConstraint) {
        this.fieldName = fieldName;
        this.violatedConstraint = violatedConstraint;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getViolatedConstraint() {
        return violatedConstraint;
    }


}
