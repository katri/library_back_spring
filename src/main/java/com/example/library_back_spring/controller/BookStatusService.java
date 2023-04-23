package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.BookStatus;
import com.example.library_back_spring.mapper.BookStatusMapper;
import com.example.library_back_spring.repository.BookStatusRepository;
import com.example.library_back_spring.view.BookStatusView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStatusService {
    @Resource
    private BookStatusMapper bookStatusMapper;

    @Resource
    private BookStatusRepository bookStatusRepository;

    public BookStatus setAsAvailable() {
      return bookStatusRepository.findByDescriptionIgnoreCase("kohal");
    }

    public List<BookStatusView> getAllStatuses() {
        return bookStatusMapper.toDto(bookStatusRepository.findAllOrdered());
    }

    public BookStatusView addNewBookStatus(BookStatusView bookStatusView) {
        BookStatus bookStatus = bookStatusMapper.toEntity(bookStatusView);
        bookStatusRepository.save(bookStatus);
        return bookStatusMapper.toDto(bookStatus);
    }
}
