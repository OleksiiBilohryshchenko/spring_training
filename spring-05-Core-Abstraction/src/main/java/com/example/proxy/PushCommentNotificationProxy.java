package com.example.proxy;

import com.example.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class PushCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for a comment");
    }
}
