package com.project.resume_builder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String showHomePage() {
        return "home"; // Возвращаем главную страницу
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        return "admin"; // Возвращаем страницу администратора
    }
}