package com.juliock.SpringPro_Session3_Exercicio.dto;

import java.time.Instant;

public class CustomError {
    private final Instant instant;
    private final Integer statusCode;
    private final String errorMessage;
    private final String path;

    public CustomError(Instant instant, Integer statusCode, String errorMessage, String path) {
        this.instant = instant;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.path = path;
    }

    public Instant getInstant() {
        return instant;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getPath() {
        return path;
    }
}
