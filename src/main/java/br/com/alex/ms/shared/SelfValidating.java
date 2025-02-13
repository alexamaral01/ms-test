package br.com.alex.ms.shared;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public abstract class SelfValidating<T> {

    private final Validator validator;

    protected SelfValidating() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    protected void selfValidate(){
        var violations = validator.validate((T)this);

        if( !violations.isEmpty()){
            throw new ConstraintViolationException(violations);

        }
    }
}
