package com.adminuiservice.controller;

import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import com.adminuiservice.service.CategoryService;
import com.adminuiservice.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    @GetMapping("/category/add")
    public String _addCategory(Model model){

        List<ParentCategory> parentCategories
                = categoryService.fetchAllParentCategories();

        model.addAttribute("parentCategories",parentCategories);

        model.addAttribute("category", new Category());
        return "category/add-category";
    }


    @PostMapping("/save/category")
    public RedirectView saveCategory(@ModelAttribute("category")
                                                         Category category){

        Map<String, Boolean> response;
        response = categoryService.save(category);
        System.out.println("Saving category => "+response);
        return new RedirectView("/categories");
    }

}
