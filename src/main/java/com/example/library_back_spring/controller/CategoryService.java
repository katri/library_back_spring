package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.Category;
import com.example.library_back_spring.mapper.CategoryMapper;
import com.example.library_back_spring.repository.CategoryRepository;
import com.example.library_back_spring.view.CategoryView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
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

    public CategoryView addNewCategory(CategoryView categoryView) {
        Category category = categoryMapper.toEntity(categoryView);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }

    public List<CategoryView> getAllCategories() {
        return categoryMapper.toDto(categoryRepository.findAllOrdered());
    }
}