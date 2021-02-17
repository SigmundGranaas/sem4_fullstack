package no.gretkas.ov2.service;

import no.gretkas.ov2.model.Author;
import no.gretkas.ov2.model.Book;
import no.gretkas.ov2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookRepository {

    @Autowired
    private BookRepository bookRepository;


    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }


    public Iterable<Book> findAllById(Iterable<Integer> iterable) {
        return bookRepository.findAllById(iterable);
    }


    public long count() {
        return bookRepository.count();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);

    }

    @Override
    public void deleteAll(Iterable<? extends Book> iterable) {
        bookRepository.deleteAll(iterable);

    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();

    }

    @Override
    public <S extends Book> Iterable<S> saveAll(Iterable<S> iterable) {
        return saveAll(iterable);
    }

    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer integer) {
        return bookRepository.existsById(integer);
    }

    public Iterable<Book> findBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    public List<Book> findBooksByAuthorsID(Integer id){
        List<Book> finalBookList = new ArrayList<Book>();
        Iterable<Book> AllBooks = bookRepository.findAll();
        for(Book book: AllBooks){
            for(Author author: book.getAuthors()){
                if(author.getId() == id){
                    finalBookList.add(book);
                }
            }
        }
    return finalBookList;
    }
    public List<Book> findBooksByAuthorFirstName(String firstName){
        List<Book> finalBookList = new ArrayList<Book>();
        Iterable<Book> AllBooks = bookRepository.findAll();
        for(Book book: AllBooks){
            for(Author author: book.getAuthors()){
                if(author.getFirstName() == firstName){
                    finalBookList.add(book);
                }
            }
        }
        return finalBookList;
    }

}
