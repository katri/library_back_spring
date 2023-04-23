package com.example.library_back_spring.controller;

import com.example.library_back_spring.mapper.UserMapper;
import com.example.library_back_spring.repository.UserRepository;
import com.example.library_back_spring.view.CategoryView;
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
}
