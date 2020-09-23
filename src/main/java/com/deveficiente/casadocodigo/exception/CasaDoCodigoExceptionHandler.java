package com.deveficiente.casadocodigo.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class CasaDoCodigoExceptionHandler {

    private final MessageSource messageSource;

    public CasaDoCodigoExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CasaDoCodigoExceptionOutput handleInvalidFormatException(MethodArgumentNotValidException exception) {
        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        return buildValidationErrors(globalErrors, fieldErrors);
    }


    private CasaDoCodigoExceptionOutput buildValidationErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        CasaDoCodigoExceptionOutput casaDoCodigoExceptionOutput = new CasaDoCodigoExceptionOutput();
        globalErrors.forEach(globalError -> casaDoCodigoExceptionOutput.addError(getErrorMesage(globalError)));
        fieldErrors.forEach(fieldError -> casaDoCodigoExceptionOutput.addFieldError(fieldError.getField(), getErrorMesage(fieldError)));
        return casaDoCodigoExceptionOutput;
    }

    private String getErrorMesage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

}
