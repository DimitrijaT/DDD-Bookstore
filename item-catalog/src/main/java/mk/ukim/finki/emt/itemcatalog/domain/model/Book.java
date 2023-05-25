package mk.ukim.finki.emt.itemcatalog.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.itemcatalog.domain.valueobjects.ItemTitle;
import mk.ukim.finki.emt.itemcatalog.domain.valueobjects.TotalPages;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.List;

@Entity
@Getter
public class Book extends AbstractEntity<ISBN> {

    @AttributeOverride(name = "title", column = @Column(name = "book_title"))
    protected ItemTitle title;

    protected int sales;

    @AttributeOverride(name = "totalPages", column = @Column(name = "total_pages"))
    private TotalPages totalPages;

    @ManyToMany
    private List<Author> author;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    protected Money price;

    public Book() {
        super(ISBN.randomId(ISBN.class));
    }

    //build method
    public static Book build(ItemTitle title, int sales, TotalPages totalPages, List<Author> author, Money price) {
        Book book = new Book();
        book.title = title;
        book.sales = sales;
        book.totalPages = totalPages;
        book.author = author;
        book.price = price;
        return book;
    }

    //add Sales
    public void addSales(int sales) {
        this.sales += sales;
    }

    //remove Sales
    public void removeSales(int sales) {
        this.sales -= sales;
    }

    //add Author
    public void addAuthor(Author author) {
        this.author.add(author);
    }

    //remove Author
    public void removeAuthor(Author author) {
        this.author.remove(author);
    }

}
