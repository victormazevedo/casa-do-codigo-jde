package com.deveficiente.casadocodigo.exception;

import java.util.ArrayList;
import java.util.List;

public class CasaDoCodigoExceptionOutput {

    private final List<String> globalErrorMessages = new ArrayList<>();
    private final List<FieldErrorOutput> fieldErrors = new ArrayList<>();

    public void addError(String message) {
        getGlobalErrorMessages().add(message);
    }

    public void addFieldError(String field, String message) {
        FieldErrorOutput fieldError = new FieldErrorOutput(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutput> getFieldErrors() {
        return fieldErrors;
    }

}
