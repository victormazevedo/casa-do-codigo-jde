package com.deveficiente.casadocodigo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = "Field value not found")
public class FieldNotFoundException extends Exception {
    public FieldNotFoundException(String msg, Throwable err) {
        super(msg, err);
    }
}
