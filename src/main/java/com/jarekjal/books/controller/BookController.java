package com.jarekjal.books.controller;

import com.jarekjal.books.entity.Author;
import com.jarekjal.books.entity.Book;
import com.jarekjal.books.model.RegisterBookDTO;
import com.jarekjal.books.repository.AuthorRepository;
import com.jarekjal.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> readBooks() {
        return ResponseEntity.ok(
                bookRepository.findAll()
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody @Valid RegisterBookDTO bookToRegister) {
        Book book = new Book();
        book.setTitle(bookToRegister.getBookTitle());
        Optional<Author> persistedAuthor = authorRepository
                .findByNameAndSurname(bookToRegister.getAuthorName(), bookToRegister.getAuthorSurname());
        Author author = persistedAuthor.orElseGet(Author::new);
        author.setName(bookToRegister.getAuthorName());
        author.setSurname(bookToRegister.getAuthorSurname());
        book.setAuthor(author);
        Book created = bookRepository.save(book);
        return ResponseEntity.created(URI.create("/book/" + created.getId())).build();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBooks() {
        bookRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
