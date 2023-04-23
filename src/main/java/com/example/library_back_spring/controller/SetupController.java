package com.example.library_back_spring.controller;

import com.example.library_back_spring.view.CategoryView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("setup/")
public class SetupController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("categories")
    public List<CategoryView> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("categories/new")
    public CategoryView addNewCategory(@RequestBody CategoryView categoryView) {
        return categoryService.addNewCategory(categoryView);
    }
}
