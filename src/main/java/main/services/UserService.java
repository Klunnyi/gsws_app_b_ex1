package main.services;

import lombok.Getter;
import main.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Getter
@Service
public class UserService {

    private final CommentRepository commentRepository;

    public UserService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

}
