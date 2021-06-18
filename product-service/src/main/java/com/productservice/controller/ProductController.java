package com.productservice.controller;

import com.productservice.entity.Product;
import com.productservice.exception.ProductNotFoundException;
import com.productservice.exception.ResourceNotFoundException;
import com.productservice.service.ProductServiceImp;
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


    //@RabbitListener(queues = ProductConfig.PRODUCT_QUEUE)
    @PostMapping("/product/create")
    public ResponseEntity <Product> createProduct(@RequestBody Product product) throws RuntimeException{
        return new ResponseEntity<>(productService.saveOrUpdateProduct(product), HttpStatus.OK);
    }
    /*
     Admin Endpoint for remove product
     */
    @GetMapping("/remove/product")
    public void removeProduct(@RequestParam String id){
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for this id :: " + id));

        productService.removeProduct(product);

    }

    /*
    User and Admin endpoint for get all product list
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get/product")
    public ResponseEntity<Optional<Product>> getSingleProduct(@RequestParam String productId){
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found for this id :: " + productId));

        return new ResponseEntity<>(Optional.of(product),HttpStatus.OK);
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
