package main.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Parrot {

    private String name;

    public Parrot() {
        name = "Test";
    }

}
