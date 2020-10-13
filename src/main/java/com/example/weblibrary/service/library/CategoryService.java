package com.example.weblibrary.service.library;

import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.repository.library.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getById(Long categoryId){
        return categoryRepository.findById(categoryId).get();
    }
}
