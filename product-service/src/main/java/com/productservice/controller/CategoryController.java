package com.productservice.controller;

import com.productservice.entity.Category;
import com.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // create category
    @PostMapping("/create/category")
    public Category createCategory(){
        Category category = new Category();
        category.setCategoryTitle("PHP");
        category.setCategoryDescription("This is PHP category");
        return categoryService.saveCategory(category);
    }

    // get all categories
    @GetMapping("/categories")
     public List<Category> getAllCategory(){
        return categoryService.fetchAllCategory();
     }
}
