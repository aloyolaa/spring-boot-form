package com.aloyolaa.springbootform.validator;

import com.aloyolaa.springbootform.validator.annotation.RequiredField;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredFieldValidator implements ConstraintValidator<RequiredField, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s);
    }

}
