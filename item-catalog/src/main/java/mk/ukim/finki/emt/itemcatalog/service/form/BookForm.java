package mk.ukim.finki.emt.itemcatalog.service.form;

import lombok.Getter;
import mk.ukim.finki.emt.itemcatalog.domain.model.Author;
import mk.ukim.finki.emt.itemcatalog.domain.valueobjects.ItemTitle;
import mk.ukim.finki.emt.itemcatalog.domain.valueobjects.TotalPages;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.List;

@Getter
public class BookForm {
    //ItemTitle title, int sales, TotalPages totalPages, List<Author> author, Money price
    private ItemTitle itemTitle;
    private int sales;
    private TotalPages totalPages;
    private String author;
    private Money price;
    private List<Author> authorList;

}
