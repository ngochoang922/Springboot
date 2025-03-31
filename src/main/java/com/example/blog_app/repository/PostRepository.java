package com.example.blog_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog_app.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByNameContaining(String name);
}
