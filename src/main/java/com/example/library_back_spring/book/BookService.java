package com.example.library_back_spring.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
   private final List<Book> books = new ArrayList<>();

    public Book addBook(BookView bookView) {
        Book book = new Book(1, bookView.getTitle(), bookView.getAuthor(), bookView.getYearPublished(), bookView.getGenre());
        books.add(book);
        return book;
    }
}
