package com.example.library_back_spring.repository;

import com.example.library_back_spring.entity.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
    BookAuthor findByLastNameAllIgnoreCase(String lastName);

    @Query("select b from BookAuthor b where upper(b.lastName) = upper(?1)")
    List<BookAuthor> findByLastName(String lastName);
}