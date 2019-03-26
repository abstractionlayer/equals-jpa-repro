package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.demo.model.Author;
import com.example.demo.model.Comment;
import com.example.demo.repos.AuthorsRepository;
import com.example.demo.repos.CommentsRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsServiceTests {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    AuthorsRepository authorsRepository;

    @Autowired
    CommentsService commentsService;

    @Autowired
    TransactionTemplate transactionTemplate;


    @Test
    public void Passing_right_author_to_check_ownership_should_return_true() {
        // Arrange.
        Comment savedComment = transactionTemplate.execute(ts -> {
            Author author = authorsRepository.save(new Author("Ivan"));

            return commentsRepository.save(new Comment("test comment", author));
        });

        // Act
        boolean result = commentsService.isCommentBelongTo(
                savedComment.getId(),
                savedComment.getAuthor().getId()
        );

        // Assert.
        Assertions.assertThat(result).isTrue();
    }

}
