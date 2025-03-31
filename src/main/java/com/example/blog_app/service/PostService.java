package com.example.blog_app.service;

import java.util.List;

import com.example.blog_app.entity.Post;

public interface PostService {

    Post savePost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    void likePost(Long postId);
    List<Post> searchByName(String name);
    void deletePost(Long postId);
    Post updatePost(Long postId, Post postDetails);

}
