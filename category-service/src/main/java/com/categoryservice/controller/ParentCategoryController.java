package com.categoryservice.controller;


import com.categoryservice.entity.ParentCategory;
import com.categoryservice.request.ParentCategoryDto;
import com.categoryservice.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ParentCategoryController {

    @Autowired
    private ParentCategoryService parentCategoryService;


    @PostMapping("/parent-category/create")
    public ParentCategoryDto createCategory(@RequestBody ParentCategoryDto parentCategoryDto){

        System.out.println(parentCategoryDto);
        parentCategoryService.saveParentCategory(parentCategoryDto);
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

    @GetMapping("/delete/parent-category")
    public Map<String,Boolean> deleteParentCategory(@RequestParam() Long id){
        ParentCategory pc = parentCategoryService.fetchSingleParentCategory(id)
                .orElseThrow(() ->new ResourceNotFoundException("Parent Category Not found by id "+id));

        parentCategoryService.remove(pc);

        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }
}
