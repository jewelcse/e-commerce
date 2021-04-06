package com.adminuiservice.controller;

import com.adminuiservice.dto.Category;
import com.adminuiservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private CategoryService categoryService;



    @RequestMapping({"/","/dashboard"})
    public String index(){
        return "dashboard";
    }

    @GetMapping("/categories")
    public String categoryList(Model model){

        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        return "category/category-list";
    }

}
