package com.juliock.SpringPro_Session3_Exercicio.services.Exceptions;

public class InvalidFieldArgumentException extends RuntimeException {
    public InvalidFieldArgumentException(String message) {
        super(message);
    }
}
