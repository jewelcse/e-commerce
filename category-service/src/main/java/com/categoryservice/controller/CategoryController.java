package com.categoryservice.controller;


import com.categoryservice.entity.Category;
import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.entity.ParentCategory;
import com.categoryservice.request.CategoryDto;
import com.categoryservice.request.ParentCategoryDto;
import com.categoryservice.service.CategoryService;
import com.categoryservice.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ParentCategoryService parentCategoryService;

    @PostMapping("/category/create")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return categoryDto;
    }

    @GetMapping("/get/categories")
    public List<Category> getAllCategory(){
        return categoryService.fetchAllCategory();
    }

    @GetMapping("/get/category")
    public Optional<Category> getSingleCategory(@RequestParam("id") Long id){

        return categoryService.fetchSingleCategory(id);
    }

    @GetMapping("/get/categoryByTitle")
    public Optional<Category> getSingleCategoryByCategoryTitle(@RequestParam("categoryTitle") String categoryTitle){

        return categoryService.fetchCategoryByTitle(categoryTitle);
    }

    @GetMapping("/delete/category")
    public Map<String,Boolean> deleteCategory(@RequestParam() Long id){
        Category c = categoryService.fetchSingleCategory(id)
                .orElseThrow(() ->new ResourceNotFoundException("Category Not found by id "+id));

        categoryService.remove(c);

        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }

    @PostMapping("/update/category")
    public Map<String,Boolean> updateCategory(@RequestBody CategoryDto categoryDto,
                                                    @RequestParam() Long id){


        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryTitle(categoryDto.getCategoryTitle());


        ParentCategory parentCategory
                = parentCategoryService.fetchSingleParentCategory(categoryDto.getParentCategoryId())
                .orElseThrow(() ->new ResourceNotFoundException("Category Not found by id "+id));


        category.setParentCategory(parentCategory);

        System.out.println(categoryDto);
        categoryService.updateCategory(category);
        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }
}
