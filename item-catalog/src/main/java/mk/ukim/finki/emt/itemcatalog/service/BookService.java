package mk.ukim.finki.emt.itemcatalog.service;

import mk.ukim.finki.emt.itemcatalog.domain.model.Book;
import mk.ukim.finki.emt.itemcatalog.domain.model.ISBN;
import mk.ukim.finki.emt.itemcatalog.service.form.BookForm;

import java.util.List;

public interface BookService {
    Book findById(ISBN id);

    Book createProduct(BookForm form);

    Book orderItemCreated(ISBN productId, int quantity);

    Book orderItemRemoved(ISBN productId, int quantity);

    List<Book> getAll();

}
