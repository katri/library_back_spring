package com.example.library_back_spring.book;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("books/")
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("new")
    @Operation(summary = "Uue raamatu loomise vormi kuvamine",
            description = "Kuvab vormi kasutajale, kuhu on võimalik sisestada uue raamatu info")
    public ModelAndView displayNewBookForm() {
        return new ModelAndView("new");
    }
}