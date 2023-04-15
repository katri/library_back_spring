package com.example.library_back_spring.book;
import lombok.Data;

@Data
public class Book {
    private String id;
    private String title;
    private String author;
    private int yearPublished;
    private String genre;

    public Book(String id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
    }
}
