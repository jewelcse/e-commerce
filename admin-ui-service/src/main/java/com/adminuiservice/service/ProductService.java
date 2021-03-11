package com.adminuiservice.service;

import com.adminuiservice.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    public Product storeProduct(Product product){
        System.out.println("service:");
        System.out.println(product);
        // rest call for product-service
        return product;
    }


}
