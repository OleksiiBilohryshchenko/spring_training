package com.example.service;

import com.example.model.Comment;
import com.example.proxy.CommentNotificationProxy;
import com.example.repository.CommentRepository;
import com.example.repository.DBCommentRepository;

public class CommentService {

    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){

        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);


    }

}
