package com.jarekjal.books.model;

import com.jarekjal.books.entity.Author;
import com.jarekjal.books.entity.Book;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class BookModel {

    @NotBlank(message = "Book's title must not be empty!")
    private String title;

    @NotNull(message = "Book's author must not be null!")
    @Valid
    private AuthorModel author;

    public static BookModel fromBook(Book book){
        return new BookModel(book.getTitle(), AuthorModel.fromAuthor(book.getAuthor()));
    }

    public static Book toBook(BookModel bookModel){
        Book book = new Book();
        book.setTitle(bookModel.getTitle());
        Author author = new Author();
        author.setName(bookModel.getAuthor().getName());
        author.setSurname(bookModel.getAuthor().getSurname());
        book.setAuthor(author);
        Set<Book> books = new HashSet<>();
        books.add(book);
        author.setBooks(books);
        return book;
    }

    BookModel (String title, AuthorModel author){
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }
}
