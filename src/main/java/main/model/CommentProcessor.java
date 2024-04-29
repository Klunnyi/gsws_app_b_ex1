package main.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CommentProcessor {
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void processComment(Comment comment) {
        // Обробка коментаря
    }

    public void validateComment(Comment comment) {
        // Валідація коментаря
    }

    public Comment getComment() {
        return this.comment;
    }
}