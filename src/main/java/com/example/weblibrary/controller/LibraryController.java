package com.example.weblibrary.controller;

import com.example.weblibrary.model.dto.BookSearchForm;
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
import java.util.stream.Collectors;

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

    @GetMapping("addBookToCategory/{categoryId}")
    public String addBookToCategory(@PathVariable("categoryId")Long categoryId, Model model){
        model.addAttribute("books", bookService.findAll().stream()
                .filter(book -> book.getCategory().stream()
                        .noneMatch(category -> category.getId().equals(categoryId)))
                .collect(Collectors.toList()));
        model.addAttribute("category", categoryService.getById(categoryId));

        return "addBookToCategory";
    }

    @GetMapping("addBookToCategory/{categoryId}/{bookId}")
    public String addBookToCategory(@PathVariable("categoryId")Long categoryId, @PathVariable("bookId")Long bookId){
        bookService.addBookToCategory(bookId, categoryId);

        return "redirect:/home";
    }

    @GetMapping("removeCategoryFromBook/{categoryId}/{bookId}")
    public String removeCategoryFromBook(@PathVariable("categoryId")Long categoryId, @PathVariable("bookId")Long bookId){
        bookService.removeCategoryFromBook(bookId, categoryId);

        return "redirect:/home";
    }

    @GetMapping("searchBook")
    public String searchBook(Model model){
        model.addAttribute("bookForm", new BookSearchForm());

        return "searchBook";
    }

    @PostMapping("searchBook")
    public String searchBook(@ModelAttribute("bookForm")@Valid BookSearchForm bookSearchForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "searchBook";
        }

        model.addAttribute("books", bookService.findAllByName(bookSearchForm.getBookName()));

        return "searchBook";
    }
}
