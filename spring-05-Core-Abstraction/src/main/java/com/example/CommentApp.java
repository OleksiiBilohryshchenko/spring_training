package com.example;

import com.example.config.CommentConfig;
import com.example.model.Comment;
import com.example.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Tom");
        comment.setText("Spring Framework");

        ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}
