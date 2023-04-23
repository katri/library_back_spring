package com.example.library_back_spring.controller;

import com.example.library_back_spring.view.CategoryView;
import com.example.library_back_spring.view.UserView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/")
public class LibraryController {
    @Resource
    private UserService userService;

    @GetMapping("users")
    public List<UserView> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("users/new")
    public UserView addNewUser(@RequestBody UserView userView) {
        return userService.addNewUser(userView);
    }
}
