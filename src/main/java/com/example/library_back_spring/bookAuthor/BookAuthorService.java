package com.example.library_back_spring.bookAuthor;

import com.example.library_back_spring.entity.BookAuthor;
import com.example.library_back_spring.repository.BookAuthorRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorRepository bookAuthorRepository;
    public BookAuthor getAuthor(String lastName) {
        return bookAuthorRepository.findByLastNameAllIgnoreCase(lastName);
    }
}
