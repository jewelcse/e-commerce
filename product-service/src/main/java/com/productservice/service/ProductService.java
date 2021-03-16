package com.productservice.service;

import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // save product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    // fetch all product
    public List<Product> fetchAllProduct(){
        return  productRepository.findAllByOrderByIdDesc();
    }

    // fetch single product
    public Optional<Product> fetchSingleProduct(String productId){
        return productRepository.findById(productId);
    }

    // delete product
    public void removeProduct(Product product){
         productRepository.delete(product);
    }
}
