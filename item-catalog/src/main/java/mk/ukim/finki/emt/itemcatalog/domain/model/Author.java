package mk.ukim.finki.emt.itemcatalog.domain.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;


@Entity
@Getter
public class Author extends AbstractEntity<AuthorId> {

    private String name;
    private String surname;

    public Author(String name, String surname) {

        this.name = name;
        this.surname = surname;
    }

    public Author() {
        super(AuthorId.randomId(AuthorId.class));
    }

    public static Author build(String name, String surname) {
        Author a = new Author();
        a.name = name;
        a.surname = surname;
        return a;
    }
}
