package com.deveficiente.casadocodigo.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue uniqueValue) {
        domainAttribute = uniqueValue.fieldName();
        aClass = uniqueValue.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + aClass.getName() + " WHERE " + domainAttribute + " = :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "More than one record of " + aClass + "with attribute " + domainAttribute + " equal: '" + value + "' was found.");
        return list.isEmpty();
    }
}
