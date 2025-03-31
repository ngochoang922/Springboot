package com.example.blog_app.service;

import java.util.Optional;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_app.entity.Comment;
import com.example.blog_app.entity.Post;
import com.example.blog_app.repository.CommentRepository;
import com.example.blog_app.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    
    public Comment saveComment(Long postId, String postedBy, String content) {
        Optional<Post> OptionalPost = postRepository.findById(postId);
        if(OptionalPost.isPresent()){
            Comment comment = new Comment();
            
            comment.setPost(OptionalPost.get());
            comment.setPostedBy(postedBy);
           
            comment.setContent(content);
            comment.setCreatedAt(new java.sql.Date(new Date().getTime()));

            return commentRepository.save(comment);
        }
        throw new EntityNotFoundException("Post not found");

}
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

     // Xóa một bình luận theo commentId
     public void deleteCommentById(Long commentId) {
        if (commentRepository.existsById(commentId)) {
            commentRepository.deleteById(commentId);
        } else {
            throw new EntityNotFoundException("Comment not found with id: " + commentId);
        }
    }

    // Xóa tất cả bình luận của một bài viết theo postId
    public void deleteCommentsByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        if (!comments.isEmpty()) {
            commentRepository.deleteAll(comments);
        } else {
            throw new EntityNotFoundException("No comments found for post with id: " + postId);
        }
    }

}

    
