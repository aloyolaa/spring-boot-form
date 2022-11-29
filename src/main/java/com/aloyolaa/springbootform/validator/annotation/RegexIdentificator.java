package com.aloyolaa.springbootform.validator.annotation;

import com.aloyolaa.springbootform.validator.RegexIdentificatorValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegexIdentificatorValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RegexIdentificator {

    String message() default "{Pattern.user.dni}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
