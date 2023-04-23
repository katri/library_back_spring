package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.Category;
import com.example.library_back_spring.repository.CategoryRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryRepository categoryRepository;

    public Category assignCategory(String bookCategoryName) {
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getCode().equals(bookCategoryName)) {
                return category;
            }
        }
        return categories.get(0);
    }
}