package com.adminuiservice.controller;

import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.service.GrandParentCategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class GrandParentCategoryController {


    @Autowired
    private GrandParentCategoryServiceImp grandParentService;


    @GetMapping("/grand-parent-category/add")
    public String __addCategory(Model model){
        model.addAttribute("grandParentCategory", new GrandParentCategory());
        return "category/grand-parent-add-category";
    }


    @PostMapping("/save/grand-parent-category")
    public RedirectView saveCategory(@ModelAttribute("grandParentCategory")
                                                         GrandParentCategory grandParentCategory){

       ResponseEntity<GrandParentCategory> response = grandParentService.save(grandParentCategory);

        System.out.println("Saving grand category => "+response);

        return new RedirectView("/categories");
    }

}
