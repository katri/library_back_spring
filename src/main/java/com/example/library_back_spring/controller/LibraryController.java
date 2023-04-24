package com.example.library_back_spring.controller;

import com.example.library_back_spring.view.BooksToUserView;
import com.example.library_back_spring.view.UserView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/")
public class LibraryController {
    @Resource
    private UserService userService;

    @Resource
    private BooksToUserService booksToUserService;

    @GetMapping("users")
    public List<UserView> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("users/new")
    public UserView addNewUser(@RequestBody UserView userView) {
        return userService.addNewUser(userView);
    }

    @PostMapping("new")
    public BooksToUserView addNewBorrowing(@RequestBody BooksToUserView booksToUserView) {
        return booksToUserService.addNewBorrowing(booksToUserView);
    }

    @PatchMapping("new")
    public void returnBorrowing(@RequestParam String bookUnCode) {
        booksToUserService.returnBorrowing(bookUnCode);
    }
}
