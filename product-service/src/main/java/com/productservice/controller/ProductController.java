package com.productservice.controller;

import com.productservice.entity.Category;
import com.productservice.entity.Product;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(){

        Product product = new Product();
        product.setProductTitle("This is product two");
        product.setProductDescription("This is product description two");
        product.setProductImagePath("htpps://www.img/two.jpg");
        product.setProductPrice(25.0);

        Category category = new Category("Laravel","This is laravel");
        product.setCategory(category);

        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.fetchAllProduct();
    }
}
