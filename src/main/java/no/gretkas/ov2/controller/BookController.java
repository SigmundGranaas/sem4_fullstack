package no.gretkas.ov2.controller;

import no.gretkas.ov2.model.Book;
import no.gretkas.ov2.service.BookService;
import no.gretkas.ov2.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class BookController {


    @Autowired
    BookService bookService;



    @GetMapping("/book")
    Iterable<Book> read(){
        return bookService.findAll();
    }

    @PostMapping("/book")
    Book create(@Valid @RequestBody Book book){
        return bookService.save(book);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());
        return fieldErrorMessages;
    }


    @PutMapping("/book")
    Book update(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/book/{id}")
    void delete(@PathVariable Integer id){
        bookService.deleteById(id);
    }

    @GetMapping("/book/{id}")
    Optional<Book> findById(@PathVariable Integer id){
        return bookService.findById(id);
    }

    @GetMapping("/book/search")
    Iterable<Book> findByQuery(@RequestParam(value = "title", required = false) String title, @RequestParam(value = "authorId", required = false) Integer id){

        if(title != null && id == null){
            return bookService.findBooksByTitle(title);
        }else if(id != null){
            return bookService.findBooksByAuthorsID(id);
        }else{
            return bookService.findAll();
        }

    }




}
