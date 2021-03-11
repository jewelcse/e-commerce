package com.productservice.controller;

import com.productservice.entity.Category;
import com.productservice.entity.Product;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/create")
    public Product createProduct(){

        Product product = new Product();
        product.setProductTitle("This is product two");
        product.setProductDescription("This is product description two");
        product.setProductImagePath("htpps://www.img/two.jpg");
        product.setProductPrice(25.0);

        Category category = new Category();
        category.setCategoryTitle("PHP");
        category.setCategoryDescription("PHP Description");
        product.setCategory(category);

        return productService.saveProduct(product);
    }

    @GetMapping("/get/products")
    public List<Product> getAllProduct(){
        return productService.fetchAllProduct();
    }

    @GetMapping("/get/product")
    public Optional<Product> getSingleProduct(@RequestParam String productId){
        return productService.fetchSingleProduct(productId);
    }

    @DeleteMapping("/remove/product")
    public void deleteProduct(@RequestParam String productId){
        productService.removeProduct(productId);
    }
}
