package main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component(value = "p")
@Primary
public class Parrot {

    String name;

    public Parrot() {
        name = "Koko";
    }

}
