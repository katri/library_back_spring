package com.example.library_back_spring.view;

import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.example.library_back_spring.entity.BooksToUser} entity
 */
@Data
public class BooksToUserView implements Serializable {
    private final Integer id;
    @NotNull
    private final LocalDate startDate;
    @NotNull
    private final LocalDate endDate;
    @NotNull
    private final String comment;
    @NotNull
    private final Book book;
    @NotNull
    private final User user;
}