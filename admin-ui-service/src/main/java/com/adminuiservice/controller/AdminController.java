package com.adminuiservice.controller;

import com.adminuiservice.service.AdminServiceImp;
import com.adminuiservice.dto.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminServiceImp adminServiceImp;



    @RequestMapping({"/","/dashboard"})
    public String index(){
        return "dashboard";
    }

    @GetMapping("/categories")
    public String categoryList(Model model){

        List<Categories> categories = adminServiceImp.getCategories();
        model.addAttribute("categories",categories);
        System.out.println(categories);
        return "category/category-list";
    }

}
