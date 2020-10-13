package com.example.weblibrary.repository.library;

import com.example.weblibrary.model.library.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByCategoryName(String categoryName);
}
