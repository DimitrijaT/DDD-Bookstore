package mk.ukim.finki.emt.itemcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.itemcatalog.domain.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class BookService {

    private final mk.ukim.finki.emt.itemcatalog.service.BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

}

