package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.Category;
import com.example.library_back_spring.view.CategoryView;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category toEntity(CategoryView categoryView);

    CategoryView toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryView categoryView, @MappingTarget Category category);
}