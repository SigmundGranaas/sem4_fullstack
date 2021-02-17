package no.gretkas.ov2.controller;

import no.gretkas.ov2.model.Author;
import no.gretkas.ov2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/author")
    Iterable<Author> read(){
        return authorRepository.findAll();
    }

    @PostMapping("/author")
    ResponseEntity<Author> create(@RequestBody Author author) throws ValidationException {
        if(author.getFirstName() != null && author.getLastName() != null){
            return new ResponseEntity(authorRepository.save(author), HttpStatus.OK);
        }else{
            throw new ValidationException("Author cannot be added without required fields");
        }
    }


    @PutMapping("/author")
    ResponseEntity<Author> update(@RequestBody Author author){
        if (authorRepository.findById(author.getId()).isPresent()){
            return new ResponseEntity(authorRepository.save(author), HttpStatus.OK);
        }else{
            return new ResponseEntity(authorRepository.save(author), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/author/{id}")
    void delete(@PathVariable Integer id){
        authorRepository.deleteById(id);
    }

    @GetMapping("/author/{id}")
    Optional<Author> findById(@PathVariable Integer id){
        return authorRepository.findById(id);
    }

    @GetMapping("/author/search")
    Iterable<Author> findByQuery(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName){
        if(firstName != null && lastName != null){
            return authorRepository.findAuthorsByFirstNameAndAndLastName(firstName, lastName);
        } else if (firstName != null){
            return authorRepository.findAuthorsByFirstName(firstName);
        } else if(lastName != null){
            return authorRepository.findAuthorsByLastName(lastName);
        }else {
            return authorRepository.findAll();
        }

    }




}
