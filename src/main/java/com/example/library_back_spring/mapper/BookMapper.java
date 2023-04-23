package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.view.BookView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(target = "category", ignore = true)
    Book toEntity(BookView bookView);

    @Mapping(target = "category", ignore = true)
    BookView toDto(Book book);
}