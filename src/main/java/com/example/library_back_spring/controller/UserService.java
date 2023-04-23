package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.User;
import com.example.library_back_spring.mapper.UserMapper;
import com.example.library_back_spring.repository.UserRepository;
import com.example.library_back_spring.view.UserView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public List<UserView> getAllUsers() {
        return userMapper.toDto(userRepository.findAllOrdered());
    }

    public UserView addNewUser(UserView userView) {
        User user = userMapper.toEntity(userView);
        userRepository.save(user);
        return userMapper.toDto(user);
     }
}
