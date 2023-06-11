package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.BookStatus;
import com.example.library_back_spring.view.BookStatusView;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookStatusMapper {
    @Mapping(target = "description", source = "statusDescription")
    BookStatus toEntity(BookStatusView bookStatusView);

    @Mapping(target = "statusDescription", source = "description")
    BookStatusView toDto(BookStatus bookStatus);
    List<BookStatusView> toDto(List<BookStatus> bookStatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    BookStatus partialUpdate(BookStatusView bookStatusView, @MappingTarget BookStatus bookStatus);
}