package main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Parrot {

    String name;

    public Parrot() {
        System.out.println("Parrot created");
        name = "Test";
    }

}
