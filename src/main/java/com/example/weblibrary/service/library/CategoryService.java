package com.example.weblibrary.service.library;

import com.example.weblibrary.model.dto.CategoryForm;
import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.repository.library.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category getByName(String name){ return categoryRepository.findByCategoryName(name);}
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getById(Long categoryId){
        return categoryRepository.findById(categoryId).get();
    }

    public void save(CategoryForm categoryForm){
        Category category = new Category();

        category.setCategoryName(categoryForm.getCategoryName());

        categoryRepository.save(category);
    }

    public void removeCategory(Long categoryId){
        Category category = categoryRepository.findById(categoryId).get();

        if(category != null)
            categoryRepository.delete(category);
    }
}
