package com.example.library_back_spring.book;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public Book addBook(BookView bookView) {
        long newBookId = books.size() + 1;
        Book book = new Book(newBookId, bookView.getTitle(), bookView.getAuthor(), bookView.getYearPublished(), bookView.getGenre());
        books.add(book);
        return book;
    }

    public ModelAndView displayNewBookForm() {
        return new ModelAndView("new");
    }

    public Book getBookBy(String id) {
        for (Book book : books) {
            if (book.getId() == parseLong(id)) {
                return book;
            }
        }
        return null;
    }
}
