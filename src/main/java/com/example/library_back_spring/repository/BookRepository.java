package com.example.library_back_spring.repository;

import com.example.library_back_spring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("""
            select b from Book b
            where upper(b.bookAuthor.firstName) = upper(?1) or upper(b.bookAuthor.lastName) = upper(?2) or upper(b.bookAuthor.middleName) = upper(?3)""")
    List<Book> findBookByAuthor(String firstName, String lastName, String middleName);

    Book findByTitleIgnoreCase(String title);

    @Override
    Optional<Book> findById(Integer integer);

    @Query("select b from Book b where b.unCode = CAST (?1 as text)")
    Book findByUnCode(Long unCode);
}