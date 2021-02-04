package com.jarekjal.books.controller;

import com.jarekjal.books.entity.Book;
import com.jarekjal.books.model.BookModel;
import com.jarekjal.books.repository.AuthorRepository;
import com.jarekjal.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

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
                bookRepository.findAll().stream().map(BookModel::fromBook).collect(Collectors.toList())
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody @Valid BookModel bookModel) {
        Book book = BookModel.toBook(bookModel);
        authorRepository.save(book.getAuthor());
        Book created = bookRepository.save(book);
        return ResponseEntity.created(URI.create("/book/" + created.getId())).build();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBooks() {
        bookRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

}
