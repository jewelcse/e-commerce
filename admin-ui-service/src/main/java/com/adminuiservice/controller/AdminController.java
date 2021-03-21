package com.adminuiservice.controller;

import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/")
    public String index(){
        return "dashboard";
    }

    @GetMapping("/categories")
    public String categoryList(Model model){


        ResponseEntity<Categories[]> responseEntity
                = restTemplate.getForEntity(RequestURLS.FETCH_CATEGORIES_URL,Categories[].class);

        List<Categories> categories = Arrays.asList(responseEntity.getBody());

        model.addAttribute("categories",categories);

        return "category/category-list";
    }

}
