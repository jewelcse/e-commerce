package com.adminuiservice.controller;

import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Product;
import com.adminuiservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public String productList(Model model){

        List<Product> products = productService.fetchAllProduct();

        System.out.println(products);
        model.addAttribute("products",products);
        return "product/product-list";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model){

        List<Categories> categories = productService.getCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/product/store")
    public RedirectView save(@ModelAttribute("product") Product product){

        Map<String, Boolean> response;

        response = productService.storeProduct(product);
        System.out.println("Saving product => "+response);

        return new RedirectView("/admin/products");
    }


    @GetMapping("/product/remove/{id}")
    public RedirectView remove(@PathVariable("id") String id){

        Map<String,Boolean> response = productService.removeProduct(id);
        System.out.println("Deleting product where ID "+ id +" "+" => "+response);

        return new RedirectView("/admin/products");
    }


}
