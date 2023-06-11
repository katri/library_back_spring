package com.example.library_back_spring.controller;

import com.example.library_back_spring.view.BookStatusView;
import com.example.library_back_spring.view.CategoryView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("setup/")
public class SetupController {
    @Resource
    private CategoryService categoryService;
    @Resource
    private BookStatusService bookStatusService;

    @GetMapping("categories")
    public List<CategoryView> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("categories/new")
    public CategoryView addNewCategory(@RequestBody CategoryView categoryView) {
        return categoryService.addNewCategory(categoryView);
    }

    @GetMapping("categories/{id}")
    public CategoryView getCategoryInfo(@PathVariable Integer id) {
        return categoryService.getCategoryInfo(id);
    }

    @PatchMapping("categories/{id}")
    public void updateCategoryInfo(@RequestBody CategoryView categoryView) {
        categoryService.updateCategoryInfo(categoryView);
    }

//    @GetMapping("statuses")
//    public List<<BookStatusView>> getAllStatuses() {
//        return bookStatusService.getAllStatuses();
//    }

    @GetMapping("statuses")
    public String getAllStatuses() {
        return bookStatusService.getAllStatusesAsString();
    }

    @GetMapping("statuses/new")
    public ModelAndView displayNewBookStatusForm() {
        return new ModelAndView("new-status");
    }

    @PostMapping("statuses/new")
    public BookStatusView addNewBookStatus(@ModelAttribute BookStatusView bookStatusView) {
        return bookStatusService.addNewBookStatus(bookStatusView);
    }
}
