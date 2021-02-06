package com.jarekjal.books.entity;

import com.jarekjal.books.model.Author;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book extends AuditData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "title")
    @NotNull
    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "name",
                    column = @Column(nullable = false, name = "author_name")
            ),
            @AttributeOverride(
                    name = "surname",
                    column = @Column(nullable = false, name = "author_surname")
            )
    })
    @NotNull
    private Author author;

    public Book() {
    }

    public Book(@NotNull String title, @NotNull Author author) {
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
