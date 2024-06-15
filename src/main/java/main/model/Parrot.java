package main.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Parrot {

    String name;

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }

}
