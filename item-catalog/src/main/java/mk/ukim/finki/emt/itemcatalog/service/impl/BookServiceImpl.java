package mk.ukim.finki.emt.itemcatalog.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.itemcatalog.domain.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.itemcatalog.domain.model.Book;
import mk.ukim.finki.emt.itemcatalog.domain.model.ISBN;
import mk.ukim.finki.emt.itemcatalog.domain.repository.BookRepository;
import mk.ukim.finki.emt.itemcatalog.service.BookService;
import mk.ukim.finki.emt.itemcatalog.service.form.BookForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book findById(ISBN id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book createProduct(BookForm form) {
        //ItemTitle title, int sales, TotalPages totalPages, List<Author> author, Money price
        Book p = Book.build(form.getItemTitle(), form.getSales(), form.getTotalPages(), form.getAuthorList(), form.getPrice());
        bookRepository.save(p);
        return p;
    }

    @Override
    public Book orderItemCreated(ISBN productId, int quantity) {
        Book p = bookRepository.findById(productId).orElseThrow(BookNotFoundException::new);
        p.addSales(quantity);
        bookRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public Book orderItemRemoved(ISBN productId, int quantity) {
        Book p = bookRepository.findById(productId).orElseThrow(BookNotFoundException::new);
        p.removeSales(quantity);
        bookRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
