package com.jarekjal.books.repository;

import com.jarekjal.books.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Page<Comment> findByPostId(Integer postId, Pageable pageable);

    Optional<Comment> findByIdAndPostId(Integer id, Integer postId);
}
