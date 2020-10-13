package com.example.weblibrary.controller;

import com.example.weblibrary.model.library.Book;
import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.service.library.BookService;
import com.example.weblibrary.service.library.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class LibraryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;

    @GetMapping("category/{categoryId}")
    public String getBooksByCategory(@PathVariable("categoryId") Long categoryId, Model model){
        Category category = categoryService.getById(categoryId);
        Set<Book> categoryBooks = bookService.findAllBooksByCategory(categoryId);

        model.addAttribute("category", category);
        model.addAttribute("books", categoryBooks);

        return "categoryBooks";
    }
}
