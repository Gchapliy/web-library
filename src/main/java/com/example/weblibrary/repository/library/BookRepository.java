package com.example.weblibrary.repository.library;

import com.example.weblibrary.model.library.Book;
import com.example.weblibrary.model.library.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findAllByCategory(Category category);
}