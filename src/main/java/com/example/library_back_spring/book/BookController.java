package com.example.library_back_spring.book;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("library")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping("/")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}