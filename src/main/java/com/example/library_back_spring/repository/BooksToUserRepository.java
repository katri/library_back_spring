package com.example.library_back_spring.repository;

import com.example.library_back_spring.entity.BooksToUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksToUserRepository extends JpaRepository<BooksToUser, Integer> {
}