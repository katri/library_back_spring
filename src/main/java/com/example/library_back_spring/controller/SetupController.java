package com.example.library_back_spring.controller;

import com.example.library_back_spring.view.CategoryView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setup/")
public class SetupController {
    @Resource
    private CategoryService categoryService;

    @PostMapping("new/category")
    public CategoryView addNewCategory(@RequestBody CategoryView categoryView) {
        return categoryService.addNewCategory(categoryView);
    }
}
