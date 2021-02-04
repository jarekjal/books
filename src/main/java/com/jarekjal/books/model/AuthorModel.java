package com.jarekjal.books.model;

import com.jarekjal.books.entity.Author;
import com.jarekjal.books.entity.Book;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorModel {

    @NotBlank(message = "Author's name must not be empty!")
    private String name;
    @NotBlank(message = "Author's surname must not be empty!")
    private String surname;

    private Set<String> bookTitles;

    AuthorModel(String name, String surname, Set<String> bookTitles){
        this.name = name;
        this.surname = surname;
        this.bookTitles = bookTitles;
    }

    public static AuthorModel fromAuthor(Author author) {
        Set<Book> books = author.getBooks();
        Set<String> titles = books.stream().map(book -> book.getTitle()).collect(Collectors.toSet());
        return new AuthorModel(author.getName(), author.getSurname(), titles);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<String> getBookTitles() {
        return bookTitles;
    }

    public void setBookTitles(Set<String> bookTitles) {
        this.bookTitles = bookTitles;
    }
}
