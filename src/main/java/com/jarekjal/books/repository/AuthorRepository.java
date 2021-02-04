package com.jarekjal.books.repository;

import com.jarekjal.books.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT ON (surname) surname, name, id FROM authors")
    List<Author> findDistinctAuthors();

}
