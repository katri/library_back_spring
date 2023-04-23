package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.BookAuthor;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors/")
public class BookAuthorController {

    @Resource
    private BookAuthorService bookAuthorService;

    @GetMapping("lastname")
    public BookAuthor getAuthor(String lastName) {
       return bookAuthorService.getAuthor(lastName);
    }
}
