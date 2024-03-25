package com.example.proxy;

import com.example.model.Comment;

public class PushNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for a comment");
    }
}
