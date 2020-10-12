package com.example.weblibrary.validator.password;

import com.example.weblibrary.model.dto.UserForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        UserForm user = (UserForm) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
