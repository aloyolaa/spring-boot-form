package com.aloyolaa.springbootform.validator.annotation;

import com.aloyolaa.springbootform.validator.RequiredFieldValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RequiredFieldValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RequiredField {

    String message() default "{NotBlank.user.lastName}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
