package com.example.library_back_spring.book;
import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String author;
    private int yearPublished;
    private String genre;
}
