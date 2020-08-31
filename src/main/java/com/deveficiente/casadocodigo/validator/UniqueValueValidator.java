package com.deveficiente.casadocodigo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> aClass;

    @Override
    public void initialize(UniqueValue uniqueValue) {
        domainAttribute = uniqueValue.fieldName();
        aClass = uniqueValue.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }
}
