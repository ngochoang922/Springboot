package com.example.blog_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; // Trả về file admin.html trong thư mục templates
    }

    @GetMapping("/home")
    public String homePage() {
        return "index";
    }
}
