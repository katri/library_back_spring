package com.example.library_back_spring.repository;

import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.entity.BookStatus;
import com.example.library_back_spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStatusRepository extends JpaRepository<BookStatus, Integer> {
    @Query("select b from BookStatus b where upper(b.description) = upper(?1)")
    BookStatus findByDescriptionIgnoreCase(String description);

    @Query("select b from BookStatus b order by b.id")
    List<BookStatus> findAllOrdered();
}