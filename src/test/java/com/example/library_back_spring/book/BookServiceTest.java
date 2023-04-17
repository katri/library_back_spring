package com.example.library_back_spring.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private final BookService bookService = new BookService();

    @Test
    void createNewBookWithAllValues() {
        BookView bookView = new BookView("Sipsik", "Eno Raud", 1980, "lastekirjandus");

        Book createdBook = bookService.addBook(bookView);

        assertEquals("Sipsik", createdBook.getTitle());
        assertEquals("Eno Raud", createdBook.getAuthor());
        assertEquals(1980, createdBook.getYearPublished());
        assertEquals("lastekirjandus", createdBook.getGenre());
    }
}