package com.deveficiente.casadocodigo.exception;

public class FieldErrorOutput {

    private final String field;
    private final String message;

    public FieldErrorOutput(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
