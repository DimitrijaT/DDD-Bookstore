package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Author implements ValueObject {
    private final String name;
    private final String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static Author of(String name, String surname) {
        return new Author(name, surname);
    }
}
