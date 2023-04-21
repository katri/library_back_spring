package com.example.library_back_spring.view;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.library_back_spring.entity.User} entity
 */
@Data
public class UserView implements Serializable {
    private final Integer id;
    @NotNull
    private final String firstName;
    private final String middleName;
    @NotNull
    private final String lastName;
    @NotNull
    private final Long personalCode;
}