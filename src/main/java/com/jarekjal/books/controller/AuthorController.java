package com.jarekjal.books.controller;

import com.jarekjal.books.model.AuthorModel;
import com.jarekjal.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> readAuthors(){
        return ResponseEntity.ok(
                authorRepository.findAll().stream().map(AuthorModel::fromAuthor).collect(Collectors.toList())
        );
    }

}
