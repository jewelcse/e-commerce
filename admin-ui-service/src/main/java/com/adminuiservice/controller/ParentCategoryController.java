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
import org.springframework.web.bind.annotation.PathVariable;
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
        List<ParentCategory> parentCategories
                =parentCategoryService.fetchAllParentCategories();

        model.addAttribute("grandParentCategories",grandParentCategories);
        model.addAttribute("parentCategories",parentCategories);
        model.addAttribute("parentCategory", new ParentCategory());

        return "category/parent-add-category";
    }


    @PostMapping("/save/parent-category")
    public RedirectView saveCategory(@ModelAttribute("parentCategory")
                                                         ParentCategory parentCategory){


        System.out.println("parent category "+ parentCategory);

        ResponseEntity<ParentCategory> response = parentCategoryService.save(parentCategory);

        System.out.println("Saving/updating parent category => "+response);

        return new RedirectView("/parent-category/add");

    }

    @GetMapping("/parent-category/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model){

        ParentCategory parentCategory = parentCategoryService.getParentCategoryById(id);

        List<GrandParentCategory> grandParentCategories
                = parentCategoryService.fetchAllGrandParentCategories();
        List<ParentCategory> parentCategories
                =parentCategoryService.fetchAllParentCategories();

        model.addAttribute("grandParentCategories",grandParentCategories);
        model.addAttribute("parentCategories",parentCategories);
        model.addAttribute("parentCategory", parentCategory);

        return "category/parent-edit-category";
    }

    @PostMapping("/update/parent-category")
    public RedirectView updateCategory(@ModelAttribute("parentCategory")
                                             ParentCategory parentCategory){


        System.out.println("Updating parent category "+ parentCategory);

        ResponseEntity<ParentCategory> response = parentCategoryService.update(parentCategory);

        System.out.println("Updating parent category => "+response);

        return new RedirectView("/parent-category/add");

    }


}
