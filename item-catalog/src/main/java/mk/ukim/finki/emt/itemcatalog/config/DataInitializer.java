package mk.ukim.finki.emt.itemcatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer {

//    private final BookRepository bookRepository;

    @PostConstruct
    public void initData() {
//        Book b1 = Book.build("Pizza Memorial", Money.valueOf(Currency.MKD, 500), 10);
//
//        Book b2 = Book.build("1984", Money.valueOf(Currency.MKD, 100), 5);
//
//        if (bookRepository.findAll().isEmpty()) {
//            bookRepository.saveAll(Arrays.asList(b1, b2));
//        }

    }
}
