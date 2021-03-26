package com.adminuiservice.controller;

import com.adminuiservice.config.ProductConfig;
import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.Product;
import com.adminuiservice.service.ProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @HystrixCommand(fallbackMethod = "getFallBackProducts")
    public String getProducts(Model model){

        List<Product> products = productService.fetchAllProduct();

        System.out.println(products);
        model.addAttribute("products",products);
        return "product/product-list";
    }

    public String getFallBackProducts(Model model){
        List<Product> products = new ArrayList<>();
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

        Map<String, Boolean> response = null;

        response.put("status",true);

        System.out.println(product + "admin ui product controller");

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

    @GetMapping("/product/edit/{id}")
    public String updateProduct(Model model,@PathVariable("id") String productId){

        Product product = productService.getSingleProduct(productId);

        List<Categories> categories = productService.getCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("product",product);


        System.out.println("fetching.."+product);
        return "product/edit-product";
    }


    @PostMapping("/product/update/{id}")
    public RedirectView update(@ModelAttribute("product") Product product){

        System.out.println("updating"+product);

        Map<String, Boolean> response;
        response = productService.updateProduct(product);
        System.out.println("Updating product => "+response);

        return new RedirectView("/admin/products");
    }



}
