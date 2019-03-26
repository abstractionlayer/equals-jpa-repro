package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Author;
import com.example.demo.model.Comment;
import com.example.demo.repos.AuthorsRepository;
import com.example.demo.repos.CommentsRepository;


@Service
@Transactional
public class CommentsService {
    private CommentsRepository commentsRepository;
    private AuthorsRepository authorsRepository;


    public CommentsService(CommentsRepository commentsRepository, AuthorsRepository authorsRepository) {
        this.commentsRepository = commentsRepository;
        this.authorsRepository = authorsRepository;
    }


    public boolean isCommentBelongTo(Long commentId, Long authorId) {
        Author owner = authorsRepository.getOne(authorId); // Enforce to get proxy.
        Comment comment = commentsRepository.findByIdOrThrow(commentId);

        return comment.isBelongTo(owner);
    }
}
