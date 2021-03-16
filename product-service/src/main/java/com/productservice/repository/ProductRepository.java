package com.productservice.repository;

import com.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findAllByOrderByIdDesc();

}
