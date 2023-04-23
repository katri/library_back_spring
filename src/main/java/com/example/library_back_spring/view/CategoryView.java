package com.example.library_back_spring.view;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.library_back_spring.entity.Category} entity
 */
@Data
public class CategoryView implements Serializable {
    @NotNull
    private final String name;
    @NotNull
    private final String code;
}