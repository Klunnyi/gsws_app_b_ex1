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
@Component(value = "p")
public class Person {

    String name;

    Parrot parrot;

    @Autowired
    public Person(Qualifier("koko") Parrot koko) {
        this.name = "test-123";
        this.parrot = koko;
        //parrot.setName("test-123");
    }

}
