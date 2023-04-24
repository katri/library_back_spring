package com.example.library_back_spring.view;

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
    private final String comment;
    @NotNull
    private final Long unCode;
    @NotNull
    private final Long personalCode;
}