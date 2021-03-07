package com.productservice.service;

import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // save product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    // get all product
    public List<Product> fetchAllProduct(){
        return  productRepository.findAll();
    }



}
