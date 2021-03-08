package com.productservice.controller;

import com.productservice.entity.Category;
import com.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
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
    @GetMapping("/get/categories")
     public List<Category> getAllCategory(){
        return categoryService.fetchAllCategory();
     }

     // get single category
    @GetMapping("/get/category")
    public Optional<Category> getSingleCategory(@RequestParam String categoryId){
        return categoryService.fetchSingleCategory(categoryId);
    }

     // delete category
    @DeleteMapping("/remove/category")
    public void deleteCategory(String categoryId){
        categoryService.removeCategory(categoryId);
    }
}
