package com.example.weblibrary.model.dto;

import com.example.weblibrary.validator.password.PasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@PasswordMatches
public class UserForm {
    @Size(min=5, max = 25, message = "At least 5 characters")
    @NotNull
    private String username;
    @Size(min=5, max = 25, message = "At least 5 characters")
    @NotNull
    private String password;
    private String confirmPassword;
}
