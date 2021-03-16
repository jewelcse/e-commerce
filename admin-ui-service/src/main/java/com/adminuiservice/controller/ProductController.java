package com.adminuiservice.controller;

import com.adminuiservice.dto.Product;
import com.adminuiservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        ResponseEntity<List<Product>> responseEntity = productService.fetchAllProduct();
        List<Product> products = responseEntity.getBody();

        for (Product product : products) {
          System.out.println(product);
        }

        model.addAttribute("products",products);
        return "product/product-list";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/product/store")
    public RedirectView save(@ModelAttribute("product") Product product){
        Product res = productService.storeProduct(product);
        System.out.println("[ProductController] :"+res);
        //return "product/product-list";
        return new RedirectView("/admin/products");
    }


    @GetMapping("/product/remove/{id}")
    public RedirectView remove(@PathVariable("id") String id){
        System.out.println("[Product Controller: ]"+id);
        Map<String,Boolean> res = productService.removeProduct(id);
        System.out.println(res);
        return new RedirectView("/admin/products");
    }


}
