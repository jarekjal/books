package com.jarekjal.books.repository;

import com.jarekjal.books.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByNameAndSurname(String name, String surname);
}
