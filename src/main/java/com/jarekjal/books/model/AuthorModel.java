package com.jarekjal.books.model;

import com.jarekjal.books.entity.Author;

import javax.validation.constraints.NotBlank;

public class AuthorModel {

    @NotBlank(message = "Author's name must not be empty!")
    private String name;
    @NotBlank(message = "Author's surname must not be empty!")
    private String surname;

    private String bookTitle;

    AuthorModel(String name, String surname, String bookTitle){
        this.name = name;
        this.surname = surname;
        this.bookTitle = bookTitle;
    }

    public static AuthorModel fromAuthor(Author author) {
        return new AuthorModel(author.getName(), author.getSurname(), author.getBook().getTitle());
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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
