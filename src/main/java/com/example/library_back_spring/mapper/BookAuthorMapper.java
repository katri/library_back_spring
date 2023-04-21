package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.BookAuthor;
import com.example.library_back_spring.view.BookAuthorView;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookAuthorMapper {
    BookAuthor toEntity(BookAuthorView bookAuthorView);

    BookAuthorView toDto(BookAuthor bookAuthor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BookAuthor partialUpdate(BookAuthorView bookAuthorView, @MappingTarget BookAuthor bookAuthor);
}