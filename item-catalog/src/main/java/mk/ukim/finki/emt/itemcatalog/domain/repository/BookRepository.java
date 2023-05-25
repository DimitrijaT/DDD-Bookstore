package mk.ukim.finki.emt.itemcatalog.domain.repository;

import mk.ukim.finki.emt.itemcatalog.domain.model.Book;
import mk.ukim.finki.emt.itemcatalog.domain.model.ISBN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, ISBN> {

}
