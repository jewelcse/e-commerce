package com.adminuiservice.controller;

import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import com.adminuiservice.service.ParentCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ParentCategoryController {


    @Autowired
    private ParentCategoryServiceImp parentCategoryService;


    @GetMapping("/parent-category/add")
    public String _addCategory(Model model){

        List<GrandParentCategory> grandParentCategories
                = parentCategoryService.fetchAllGrandParentCategories();

        model.addAttribute("grandParentCategories",grandParentCategories);

        model.addAttribute("parentCategory", new ParentCategory());
        return "category/parent-add-category";
    }


    @PostMapping("/save/parent-category")
    public RedirectView saveCategory(@ModelAttribute("parentCategory")
                                                         ParentCategory parentCategory){


        ResponseEntity<ParentCategory> response = parentCategoryService.save(parentCategory);

        System.out.println("Saving parent category => "+response);
        return new RedirectView("/categories");

    }

}
