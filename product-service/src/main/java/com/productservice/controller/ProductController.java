package com.productservice.controller;

import com.productservice.config.ProductConfig;
import com.productservice.entity.Product;
import com.productservice.service.ProductServiceImp;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;

    /*
    Admin Endpoint for add product
     */
    //@RabbitListener(queues = ProductConfig.PRODUCT_QUEUE)
    @PostMapping("/product/create")
    public Product createProduct(@RequestBody Product product){
        System.out.println(product+" Product service");
        return productService.saveOrUpdateProduct(product);
    }
    /*
     Admin Endpoint for remove product
     */
    @GetMapping("/remove/product")
    public Map<String,Boolean> removeProduct(@RequestParam String id){
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        productService.removeProduct(product);

       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
    }

    /*
    User and Admin endpoint for get all product list
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get/products")
    public ResponseEntity<List<Product>> getAllProduct(){

        HttpHeaders headers = new HttpHeaders();
        headers.set("ACCESS_CONTROL_ALLOW_ORIGIN","*");
        List<Product> products = productService.getProducts();
        //return new ResponseEntity<>(products, HttpStatus.OK);
        return ResponseEntity.ok().header(String.valueOf(headers)).body(products);
    }

    @GetMapping("/get/product")
    public Optional<Product> getSingleProduct(@RequestParam String productId){
        return productService.getProductById(productId);
    }

    @PostMapping("/update/product/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable String id) {
        try {
            Product existingProduct = productService.getProductById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

            product.setId(id);
            productService.saveOrUpdateProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
