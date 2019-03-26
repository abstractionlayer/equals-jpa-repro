package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;


public interface CommentsRepository extends JpaRepository<Comment, Long> {

    default Comment findByIdOrThrow(Long commentId) {
        return findById(commentId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
