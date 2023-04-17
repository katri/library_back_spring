package com.example.library_back_spring.book;

import lombok.Data;

@Data
public class BookView {
    private String title;
    private String author;
    private int yearPublished;
    private String genre;

    public BookView(String title, String author, int yearPublished, String genre) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
    }
}