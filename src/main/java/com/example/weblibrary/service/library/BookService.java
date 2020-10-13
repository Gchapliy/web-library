package com.example.weblibrary.service.library;

import com.example.weblibrary.model.library.Book;
import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.repository.library.BookRepository;
import com.example.weblibrary.repository.library.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public Set<Book> findAllBooksByCategory(Long categoryId){
        Category category = categoryRepository.findById(categoryId).get();

        return category.getBooks();
    }
}
