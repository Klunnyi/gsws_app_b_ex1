package main.services;

import lombok.Getter;
import lombok.Setter;
import main.aspects.ToLog;
import main.model.Comment;
import main.model.CommentProcessor;
import main.proxies.CommentNotificationProxy;
import main.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Getter
@Setter
@Service
@Lazy
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired
    private ApplicationContext context;

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(@Qualifier("PROXY") CommentRepository commentRepository,
                          @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
    }

    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment:" + comment.getText());
    }


    public void sendComment(Comment c) {
        CommentProcessor commentProcessor = context.getBean(CommentProcessor.class);
        commentProcessor.processComment(c);
        commentProcessor.validateComment(c);
    }
}