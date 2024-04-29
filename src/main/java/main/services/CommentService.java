package main.services;

import lombok.Getter;
import lombok.Setter;
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
        System.out.println("Comment Service");
    }

    public void publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public void sendComment(Comment c) {
        CommentProcessor commentProcessor = context.getBean(CommentProcessor.class);
        commentProcessor.processComment(c);
        commentProcessor.validateComment(c);
    }
}