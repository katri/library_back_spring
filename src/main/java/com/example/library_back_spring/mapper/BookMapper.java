package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.view.BookView;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    Book toEntity(BookView bookView);

    BookView toDto(Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Book partialUpdate(BookView bookView, @MappingTarget Book book);
}