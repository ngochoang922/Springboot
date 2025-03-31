package com.example.blog_app.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_app.entity.Post;
import com.example.blog_app.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());
        
        return postRepository.save(post);
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        Optional<Post> OptionalPost = postRepository.findById(postId);
        if(OptionalPost.isPresent()) {
            Post existingPost = OptionalPost.get();
            existingPost.setViewCount(existingPost.getViewCount() + 1);
            return postRepository.save(existingPost);
        } else {
            throw new RuntimeException("Post not found with id: " + postId);
        }
    }

    public void likePost(Long postId) {
        Optional<Post> OptionalPost = postRepository.findById(postId);
        if(OptionalPost.isPresent()) {
           Post post = OptionalPost.get();
            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
        } else {
            throw new RuntimeException("Post not found with id: " + postId);
        }
    }

    public List<Post> searchByName(String name) {
        return postRepository.findByNameContaining(name);
    }
    // Cập nhật bài viết
    public Post updatePost(Long postId, Post postDetails) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setTitle(postDetails.getTitle());
            post.setContent(postDetails.getContent());
            return postRepository.save(post);
        } else {
            throw new RuntimeException("Post not found with id: " + postId);
        }
    }

    // Xoá bài viết
    public void deletePost(Long postId) {
        if (postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
        } else {
            throw new RuntimeException("Post not found with id: " + postId);
        }
    }
    
}
