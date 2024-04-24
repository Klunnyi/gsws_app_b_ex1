package main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component(value = "p")
public class Parrot {

    String name;

    public Parrot() {
        name = "Koko";
    }

}
