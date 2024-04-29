package main.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CommentProcessor {

    private Comment comment;

    public void processComment(Comment comment) {
        // Обробка коментаря
    }

    public void validateComment(Comment comment) {
        // Валідація коментаря
    }

}