package com.example.library_back_spring.book;

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
    public String getBookBy(@PathVariable String id) {
        return bookService.getBookBy(id);
    }

    @GetMapping("/")
    public String getAllBooks() {
        return bookService.getAllBooks();
    }
}