package com.jarekjal.books.controller;

import com.jarekjal.books.entity.Book;
import com.jarekjal.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book create(@Valid @RequestBody Book requestBook) {
        return bookRepository.save(requestBook);
    }

}
