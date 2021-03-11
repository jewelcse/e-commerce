package com.adminuiservice.controller;

import com.adminuiservice.dto.Product;
import com.adminuiservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String productList(){
        return "product/product-list";
    }

    @GetMapping("/product/add")
    public String addproduct(Model model){
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/product/store")
    public String save(@ModelAttribute("product") Product product, Model model){
        System.out.println("productController");
        System.out.println(product);
        productService.storeProduct(product);
        return "product/product-list";
    }



}
