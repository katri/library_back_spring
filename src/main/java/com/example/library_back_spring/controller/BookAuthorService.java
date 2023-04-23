package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.BookAuthor;
import com.example.library_back_spring.repository.BookAuthorRepository;
import com.example.library_back_spring.view.BookView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService {

    @Resource
    private BookAuthorRepository bookAuthorRepository;

    public BookAuthor getAuthor(String lastName) {
        return bookAuthorRepository.findByLastNameAllIgnoreCase(lastName);
    }

    public BookAuthor assignAuthor(BookView bookView) {
        String lastName = bookView.getBookAuthorLastName();
        String firstName = bookView.getBookAuthorFirstName();
        String middleName = bookView.getBookAuthorMiddleName();
        List<BookAuthor> authors = bookAuthorRepository.findByLastName(lastName);
        if (authors.isEmpty()) {
            BookAuthor newBookAuthor = new BookAuthor();
            newBookAuthor.setFirstName(firstName);
            newBookAuthor.setMiddleName(middleName);
            newBookAuthor.setLastName(lastName);
            bookAuthorRepository.save(newBookAuthor);
            return newBookAuthor;
        } else if (authors.size() > 1) {
            for (BookAuthor author : authors) {
                if (author.getFirstName().equals(firstName) && author.getMiddleName().equals(middleName)) {
                    return author;
                }
            }
        }
        return authors.get(0);
    }
}
