package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.view.BookView;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("books/")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("new")
    @Operation(summary = "Uue raamatu loomise vormi kuvamine",
            description = "Kuvab vormi kasutajale, kuhu on võimalik sisestada uue raamatu info")
    public ModelAndView displayNewBookForm() {
        return bookService.displayNewBookForm();
    }

    @PostMapping("new")
    public Book addBook(@RequestBody BookView bookView) {
        return bookService.addBook(bookView);
    }

    @GetMapping("{id}")
    public String getBookBy(@PathVariable Integer id) {
        return bookService.getBookBy(id);
    }

    @GetMapping("/")
    public String getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String name) {
        return bookService.getBooksByAuthor(name);
    }

    @GetMapping("/title")
    public BookView getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }
}