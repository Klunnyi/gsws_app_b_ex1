package main.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommentProcessorProxy {
    @Autowired
    private ApplicationContext context;

    public void processAndValidateComment(Comment c) {
        CommentProcessor p = context.getBean(CommentProcessor.class);
        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);
    }

    public Comment getComment() {
        CommentProcessor p = context.getBean(CommentProcessor.class);
        return p.getComment();
    }
}
