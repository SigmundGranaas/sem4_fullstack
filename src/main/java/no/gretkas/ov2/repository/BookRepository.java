package no.gretkas.ov2.repository;

import no.gretkas.ov2.model.Author;
import no.gretkas.ov2.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Integer> {

    Iterable<Book> findBooksByTitle(String title);



}
