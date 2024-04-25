package main.repositories;

import main.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
