package com.example.library_back_spring.view;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.library_back_spring.entity.Book} entity
 */
@Data
public class BookView implements Serializable {

    @NotNull
    private final String title;
    @NotNull
    private final String bookAuthorFirstName;
    private final String bookAuthorMiddleName;
    @NotNull
    private final String bookAuthorLastName;
    @NotNull
    private final Integer yearPublished;
    @NotNull
    private final String category;
}