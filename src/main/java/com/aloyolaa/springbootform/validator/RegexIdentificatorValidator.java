package com.aloyolaa.springbootform.validator;

import com.aloyolaa.springbootform.validator.annotation.RegexIdentificator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexIdentificatorValidator implements ConstraintValidator<RegexIdentificator, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("\\d{8}");
    }

}
