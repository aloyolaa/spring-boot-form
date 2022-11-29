package com.aloyolaa.springbootform.validator;

import com.aloyolaa.springbootform.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotBlank.user.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "NotBlank.user.dni");
        /*if (!user.getDni().matches("\\d{8}")) {
            errors.rejectValue("dni", "Pattern.user.dni");
        }*/
    }

}
