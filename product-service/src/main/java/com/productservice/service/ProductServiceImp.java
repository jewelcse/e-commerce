package com.productservice.service;

import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp  implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Product product){
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProducts() {
        return  productRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        return productRepository.findById(productId);
    }
}
