package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.BookStatus;
import com.example.library_back_spring.view.BookStatusView;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookStatusMapper {
    BookStatus toEntity(BookStatusView bookStatusView);

    BookStatusView toDto(BookStatus bookStatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BookStatus partialUpdate(BookStatusView bookStatusView, @MappingTarget BookStatus bookStatus);
}