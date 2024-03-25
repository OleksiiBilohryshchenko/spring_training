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

        CommentService cs1 = container.getBean(CommentService.class);
        CommentService cs2 = container.getBean(CommentService.class);

        System.out.println(cs1);
        System.out.println(cs2);
        System.out.println(cs1==cs2); // same object without prototype and different obj with it

    }



}

