package com.adminuiservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/")
    public String index(){
        return "dashboard";
    }

    @GetMapping("/categories")
    public String categoryList(){
        return "category/category-list";
    }

}
