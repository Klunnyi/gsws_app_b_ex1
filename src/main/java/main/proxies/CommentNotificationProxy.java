package main.proxies;

import main.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);

}