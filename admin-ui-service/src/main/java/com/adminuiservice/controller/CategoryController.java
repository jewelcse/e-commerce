package com.adminuiservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class CategoryController {


    @GetMapping("/categories")
    public String categoryList(){
        return "category/category-list";
    }

    @GetMapping("/category/add")
    public String addCategory(){
        return "category/add-category";
    }

    @GetMapping("/_category/add")
    public String _addCategory(){
        return "category/_add-category";
    }

    @GetMapping("/__category/add")
    public String __addCategory(){
        return "category/__add-category";
    }
}
