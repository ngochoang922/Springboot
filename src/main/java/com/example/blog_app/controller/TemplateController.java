package com.example.blog_app.controller;

import com.example.blog_app.entity.Post;
import com.example.blog_app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class TemplateController {

    private final PostService postService; // để lấy dữ liệu dưới db này

    public TemplateController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        List<Post> posts = postService.getAllPosts(); // tao lấy dc danh sách post nhé
        model.addAttribute("posts", posts);  // đẩy xuống thymeleaf này
        return "blog"; // return về blog có nghĩa là đẩy danh sách post xuống cho thằng blog.html
        // oke không
        // giờ t vào blog xử lý dữ liệu này
    }
}
