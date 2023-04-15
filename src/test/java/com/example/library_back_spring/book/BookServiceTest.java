package com.example.library_back_spring.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private final BookService bookService = new BookService();

    @Test
    void createNewBookWithAllValues() {

        Book book = new Book("1", "Sipsik", "Eno Raud", 1980, "lastekirjandus");
        Book createdBook = bookService.addBook(book);

        assertEquals("1", createdBook.getId());
        assertEquals("Sipsik", createdBook.getTitle());
        assertEquals("Eno Raud", createdBook.getAuthor());
        assertEquals(1980, createdBook.getYearPublished());
        assertEquals("lastekirjandus", createdBook.getGenre());
    }
}