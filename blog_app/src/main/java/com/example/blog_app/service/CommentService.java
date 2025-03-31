package com.example.blog_app.service;

import java.util.List;

import com.example.blog_app.entity.Comment;

public interface CommentService {
    Comment saveComment(Long postId, String postedBy, String content);
    List<Comment> getCommentsByPostId(Long postId);
    void deleteCommentsByPostId(Long postId);
    void deleteCommentById(Long commentId);
}
