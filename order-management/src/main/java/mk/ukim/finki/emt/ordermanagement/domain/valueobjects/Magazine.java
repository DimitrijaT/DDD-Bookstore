//package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Getter;
//import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
//import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
//import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
//
//import java.util.List;
//
//@Getter
//public class Magazine implements Item, ValueObject {
//    private final ISSN id;
//    private final ItemTitle title;
//    private final IssueNumber issueNumber;
//    private final Money price;
//
//    private Magazine() {
//        this.id = ISSN.randomId(ISSN.class);
//        this.title = ItemTitle.of("");
//        this.issueNumber = IssueNumber.of(0L);
//        this.price = Money.valueOf(Currency.MKD, 0);
//    }
//
//    @JsonCreator
//    public Magazine(@JsonProperty("id") ISSN id,
//                    @JsonProperty("title") ItemTitle title,
//                    @JsonProperty("price") Money price,
//                    @JsonProperty("totalPages") IssueNumber issueNumber,
//                    @JsonProperty("authorList") List<Author> authorList) {
//        this.id = id;
//        this.title = title;
//        this.price = price;
//        this.issueNumber = issueNumber;
//
//    }
//}
