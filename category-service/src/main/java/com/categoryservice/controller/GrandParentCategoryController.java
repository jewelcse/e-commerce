package com.categoryservice.controller;


import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.service.GrandParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class GrandParentCategoryController {

    @Autowired
    private GrandParentCategoryService grandParentCategoryService;

    @PostMapping("/grand-parent-category/create")
    public GrandParentCategory createCategory(@RequestBody GrandParentCategory grandParentCategory){
        grandParentCategoryService.saveGrandParentCategory(grandParentCategory);
        return grandParentCategory;
    }

    @GetMapping("/get/grand-parent-categories")
    public List<GrandParentCategory> getAllGrandParentCategory(){
        return grandParentCategoryService.fetchAllGrandParentCategory();
    }

    @GetMapping("/get/grand-parent-category")
    public Optional<GrandParentCategory> getSingleGrandParentCategory(@RequestParam("id") Long id){

        return grandParentCategoryService.fetchSingleGrandParentCategory(id);
    }

    @GetMapping("/delete/grand-parent-category")
    public Map<String,Boolean> deleteGrandParentCategory(@RequestParam() Long id){
       GrandParentCategory gp = grandParentCategoryService.fetchSingleGrandParentCategory(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grand Parent Category Not found by id " + id));

        grandParentCategoryService.remove(gp);

        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }

    @PostMapping("/update/grand-parent-category")
    public Map<String,Boolean> updateGrandParentCategory(@RequestBody GrandParentCategory grandParentCategory,
                                                         @RequestParam() Long id){

        grandParentCategory.setId(id);
        grandParentCategoryService.saveGrandParentCategory(grandParentCategory);

        Map<String,Boolean> response = new HashMap<>();
        response.put("status",true);
        return  response;

    }


}
