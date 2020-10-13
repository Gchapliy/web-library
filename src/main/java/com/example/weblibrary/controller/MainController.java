package com.example.weblibrary.controller;

import com.example.weblibrary.model.library.Category;
import com.example.weblibrary.repository.library.CategoryRepository;
import com.example.weblibrary.service.library.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "/index";
    }

    @GetMapping("home")
    public String home(Model model){
        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("categories", categories);

        return "home";
    }
}
