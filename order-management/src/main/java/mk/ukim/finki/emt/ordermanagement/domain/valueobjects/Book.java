package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Book implements Item, ValueObject {
    private final ISBN id;
    private final ItemTitle title;
    private final TotalPages totalPages;
    private final Money price;
    private final List<Author> authorList;

    private Book() {
        this.id = ISBN.randomId(ISBN.class);
        this.title = ItemTitle.of("");
        this.totalPages = TotalPages.of(0L);
        this.price = Money.valueOf(Currency.MKD, 0);
        this.authorList = new ArrayList<>();
    }

    @JsonCreator
    public Book(@JsonProperty("id") ISBN id,
                @JsonProperty("title") ItemTitle title,
                @JsonProperty("price") Money price,
                @JsonProperty("totalPages") TotalPages totalPages,
                @JsonProperty("authorList") List<Author> authorList) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.totalPages = totalPages;
        this.authorList = authorList;
    }
}
