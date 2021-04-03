package com.adminuiservice.controller;

import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.service.GrandParentCategoryServiceImp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
public class GrandParentCategoryController {


    @Autowired
    private GrandParentCategoryServiceImp grandParentService;


    @GetMapping("/grand-parent-category/add")
    public String __addCategory(Model model){
        List<GrandParentCategory> grandParentCategories = grandParentService.getAllGrandParentCategories();
        model.addAttribute("grandParentCategories",grandParentCategories);
        model.addAttribute("grandParentCategory", new GrandParentCategory());
        model.addAttribute("add-btn","Add New Category");
        return "category/grand-parent-add-category";
    }



    @PostMapping("/save/grand-parent-category")
    public RedirectView saveCategory(@ModelAttribute("grandParentCategory")
                                                         GrandParentCategory grandParentCategory){
        GrandParentCategory response = grandParentService.save(grandParentCategory);
        System.out.println("Saving/updating grand category => "+response);

        return new RedirectView("/grand-parent-category/add");
    }

//    @GetMapping("/grand-parent-category/remove/{id}")
//    public RedirectView removeCategory(@PathVariable("id") Long id){
//
//        //System.out.println("ggggggggID "+id);
//        grandParentService.removeGrandParentCategory(id);
//
//        return new RedirectView("/grand-parent-category/add");
//    }

    @GetMapping("/grand-parent-category/edit/{id}")
    public String editCategory(@PathVariable("id") Long id,Model model){

        GrandParentCategory grandParentCategory = grandParentService.getGrandParentCategoryById(id);

        List<GrandParentCategory> grandParentCategories = grandParentService.getAllGrandParentCategories();


        model.addAttribute("grandParentCategories",grandParentCategories);

        model.addAttribute("grandParentCategory",grandParentCategory);
        model.addAttribute("update-btn","Update");

        return "category/grand-parent-add-category";
    }




}
