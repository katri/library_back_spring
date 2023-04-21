package com.example.library_back_spring.book;
import com.example.library_back_spring.helper.CodeGenerator;
import lombok.Data;

@Data
public class Book {
    private long id;
    private String title;
    private String author;
    private int yearPublished;
    private String genre;
    private long bookCode;

    public Book(long id, String title, String author, int yearPublished, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.bookCode = new CodeGenerator().generate();
    }
}
