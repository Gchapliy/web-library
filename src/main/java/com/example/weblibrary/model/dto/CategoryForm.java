package com.example.weblibrary.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CategoryForm {
    @Size(min = 5, max = 20, message = "At least 5 characters")
    @NotNull
    private String categoryName;
}
