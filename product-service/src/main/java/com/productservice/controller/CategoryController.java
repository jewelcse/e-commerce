package com.productservice.controller;

import com.productservice.entity.Category;
import com.productservice.entity.SubCategory1;
import com.productservice.entity.SubCategory2;
import com.productservice.entity.SubCategory3;
import com.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // create category
    @PostMapping("/create/category")
    public Category createCategory(){

        Category category = new Category();
        category.setCategoryTitle("Accessories");

        category.setCategoryDescription("This is PHP category");
        return categoryService.saveCategory(category);
    }

    // create sub-category-1





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
