package com.categoryservice.controller;


import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.entity.ParentCategory;
import com.categoryservice.service.CategoryService;
import com.categoryservice.service.GrandParentCategoryService;
import com.categoryservice.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ParentCategoryController {

    @Autowired
    private ParentCategoryService parentCategoryService;

    @Autowired
    private GrandParentCategoryService grandParentCategoryService;

    @PostMapping("/parent-category/create")
    public ParentCategory createCategory(){

        ParentCategory pc = new ParentCategory();
        pc.setId(120L);
        pc.setParentCategoryTitle("TV");

       List<GrandParentCategory> grandParentCategories =  grandParentCategoryService.fetchAllGrandParentCategory();

       pc.setGrandParentCategory(grandParentCategories.get(0));


        parentCategoryService.saveGrandParentCategory(pc);
        return pc;
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
