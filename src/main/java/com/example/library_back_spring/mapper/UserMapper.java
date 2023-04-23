package com.example.library_back_spring.mapper;

import com.example.library_back_spring.entity.User;
import com.example.library_back_spring.view.UserView;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserView userView);

    UserView toDto(User user);

    List<UserView> toDto(List<User> user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserView userView, @MappingTarget User user);
}