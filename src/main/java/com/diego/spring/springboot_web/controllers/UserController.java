package com.diego.spring.springboot_web.controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.diego.spring.springboot_web.controllers.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Diego", "Guerrero");
        model.addAttribute("Title", "Hola Diego con Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("Title", "Lista de usuarios disponibles");
        return "list";

    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        List<User> users = Arrays.asList(
                new User("Diego", "Guerrero", "diego@gmail.com"),
                new User("Nahomy", "Revelo", "nahomy@gmail.com"),
                new User("felipe", "saa"));

        return users;
    }
}