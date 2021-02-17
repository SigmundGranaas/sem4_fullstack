package no.gretkas.ov2.repository;

import no.gretkas.ov2.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Iterable<Author> findAuthorsByFirstNameAndAndLastName(String firstName, String lastName);

    Iterable<Author> findAuthorsByFirstName(String firstName);

    Iterable<Author> findAuthorsByLastName(String lastName);


}
