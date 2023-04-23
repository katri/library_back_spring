package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.BooksToUser;
import com.example.library_back_spring.view.BooksToUserView;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BooksToUserMapper {
    BooksToUser toEntity(BooksToUserView booksToUserView);

    BooksToUserView toDto(BooksToUser booksToUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BooksToUser partialUpdate(BooksToUserView booksToUserView, @MappingTarget BooksToUser booksToUser);
}