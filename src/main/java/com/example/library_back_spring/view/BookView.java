package com.example.library_back_spring.view;

import com.example.library_back_spring.entity.BookAuthor;
import com.example.library_back_spring.entity.BookStatus;
import com.example.library_back_spring.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.library_back_spring.entity.Book} entity
 */
@Data
public class BookView implements Serializable {
    private final Integer id;
    @NotNull
    private final String title;
    @NotNull
    private final Integer yearPublished;
    @NotNull
    private final String unCode;
    @NotNull
    private final Category category;
    @NotNull
    private final BookAuthor bookAuthor;
    @NotNull
    private final BookStatus bookStatus;
}