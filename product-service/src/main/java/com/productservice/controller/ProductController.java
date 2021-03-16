package com.productservice.controller;

import com.productservice.entity.Product;
import com.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
    Admin Endpoint for add product
     */
    @PostMapping("/product/create")
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    /*
     Admin Endpoint for remove product
     */
    @GetMapping("/remove/product")
    public Map<String,Boolean> removeProduct(@RequestParam String id){
        Product product = productService.fetchSingleProduct(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        productService.removeProduct(product);

       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }

//    @GetMapping("/remove/product/{id}")
//    public Map<String,Boolean> deleteProduct(@PathVariable(value = "id")
//                                                         String productId){
//
//        Product product = productService.fetchSingleProduct(productId)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
//
//        productService.removeProduct(product);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

    /*
    User and Admin endpoint for get all product list
     */
    @GetMapping("/get/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.fetchAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get/product")
    public Optional<Product> getSingleProduct(@RequestParam String productId){
        return productService.fetchSingleProduct(productId);
    }


}
