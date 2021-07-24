package com.productservice.service;

import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImp  implements ProductService{


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository repository){
        this.productRepository = repository;
    }


    @Override
    public Product saveOrUpdateProduct(Product product) {
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @Override
    public void removeProduct(Product product){
         productRepository.delete(product);
    }

    @Override
    public List<Product> getProducts() {
        System.out.println("Fetching Data from Database");
        return  productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        return productRepository.findById(productId);
    }
}
