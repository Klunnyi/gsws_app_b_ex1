package main.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component(value = "person")
public class Person {

    String name;

    Parrot parrot;

    @Autowired
    public Person(Parrot miki) {
        this.parrot = miki;
    }
    @Autowired
    public Person(@Qualifier("p") Parrot p) {
        this.name = "test-123";
        this.parrot = p;
    }

}
