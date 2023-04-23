package com.example.library_back_spring.repository;

import com.example.library_back_spring.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStatusRepository extends JpaRepository<BookStatus, Integer> {
    @Query("select b from BookStatus b where upper(b.description) = upper(?1)")
    BookStatus findByDescriptionIgnoreCase(String description);
}