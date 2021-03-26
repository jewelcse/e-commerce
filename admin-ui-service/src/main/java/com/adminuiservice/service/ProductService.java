package com.adminuiservice.service;

import com.adminuiservice.dto.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> fetchAllProduct();
    Product getSingleProduct(String productId);
    ResponseEntity<Product> storeProduct(Product product);
    ResponseEntity<Product> removeProduct(String id);
    void updateProduct(Product product);

}
