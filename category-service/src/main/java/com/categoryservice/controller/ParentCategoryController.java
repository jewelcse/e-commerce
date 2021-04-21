package com.categoryservice.controller;


import com.categoryservice.entity.Category;
import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.entity.ParentCategory;
import com.categoryservice.request.ParentCategoryDto;
import com.categoryservice.service.CategoryService;
import com.categoryservice.service.GrandParentCategoryService;
import com.categoryservice.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ParentCategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ParentCategoryService parentCategoryService;

    @Autowired
    private GrandParentCategoryService grandParentCategoryService;

    @PostMapping("/parent-category/create")
    public ParentCategoryDto createCategory(@RequestBody ParentCategoryDto parentCategoryDto){
        parentCategoryService.saveParentCategory(parentCategoryDto);
        System.out.println(parentCategoryDto);
        return parentCategoryDto;
    }

    @GetMapping("/get/parent-categories")
    public List<ParentCategory> getAllParentCategory(){
        return parentCategoryService.fetchAllParentCategory();
    }

    @GetMapping("/get/parent-category")
    public Optional<ParentCategory> getSingleParentCategory(@RequestParam("id") Long id){

        return parentCategoryService.fetchSingleParentCategory(id);
    }

    @GetMapping("/get/parent-category/child-category")
    public List<Category> getParentCategories(@RequestParam("id") Long id){

        return categoryService.fetchParentCategories(id);
    }

    @GetMapping("/delete/parent-category")
    public Map<String,Boolean> deleteParentCategory(@RequestParam() Long id){
        ParentCategory pc = parentCategoryService.fetchSingleParentCategory(id)
                .orElseThrow(() ->new ResourceNotFoundException("Parent Category Not found by id "+id));

        parentCategoryService.remove(pc);

        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }

    @PostMapping("/update/parent-category")
    public Map<String,Boolean> updateParentCategory(@RequestBody ParentCategoryDto parentCategoryDto,
                                                         @RequestParam() Long id){


        ParentCategory parentCategory = new ParentCategory();
        parentCategory.setId(parentCategoryDto.getId());
        parentCategory.setParentCategoryTitle(parentCategoryDto.getParentCategoryTitle());


        GrandParentCategory grandParentCategory
                = grandParentCategoryService.fetchSingleGrandParentCategory(parentCategoryDto.getGrandParentCategoryId())
                .orElseThrow(() ->new ResourceNotFoundException("Parent Category Not found by id "+id));


        parentCategory.setGrandParentCategory(grandParentCategory);

        System.out.println(parentCategoryDto);
        parentCategoryService.updateParentCategory(parentCategory);
        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }
}
