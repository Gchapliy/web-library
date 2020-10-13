package com.example.weblibrary.controller;

import com.example.weblibrary.model.dto.CategoryForm;
import com.example.weblibrary.model.library.Book;
import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.service.library.BookService;
import com.example.weblibrary.service.library.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("addNewCategory")
    public String addNewCategory(Model model){
        model.addAttribute("categoryForm", new CategoryForm());

        return "addNewCategory";
    }

    @PostMapping("addNewCategory")
    public String addNewCategory(@ModelAttribute("categoryForm")@Valid CategoryForm categoryForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {

            return "addNewCategory";
        }

        Category category = categoryService.getByName(categoryForm.getCategoryName());

        if(category != null){
            model.addAttribute("error", "category already exists");

            return "addNewCategory";
        }

        categoryService.save(categoryForm);

        return "redirect:/home";
    }

    @GetMapping("removeCategory/{categoryId}")
    public String removeCategory(@PathVariable("categoryId")Long categoryId){
        categoryService.removeCategory(categoryId);

        return "redirect:/home";
    }
}
