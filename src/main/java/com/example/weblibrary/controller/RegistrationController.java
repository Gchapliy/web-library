package com.example.weblibrary.controller;

import com.example.weblibrary.model.dto.UserForm;
import com.example.weblibrary.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());

        return "registration";
    }

    @PostMapping("registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getCode() + " " + objectError.getDefaultMessage());
                if (objectError.getCode().contains("PasswordMatches")) {

                    model.addAttribute("confirmPasswordError", objectError.getDefaultMessage());
                }
            });
            return "registration";
        }

        if (userService.findUserByName(userForm.getUsername()) != null){
            model.addAttribute("userExistsError", "User with name " + userForm.getUsername() + " already exists");
            return "registration";
        }

        userService.saveUser(userForm);
        return "redirect:/login";
    }
}
