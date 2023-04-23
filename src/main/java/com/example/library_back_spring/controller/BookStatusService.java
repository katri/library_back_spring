package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.BookStatus;
import com.example.library_back_spring.repository.BookStatusRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookStatusService {

    @Resource
    private BookStatusRepository bookStatusRepository;


    public BookStatus setAsAvailable() {
      return bookStatusRepository.findByDescriptionIgnoreCase("kohal");
    }
}
