package com.adminuiservice.service;

import com.adminuiservice.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    List<Categories> getCategories();
    List<ParentCategory> getParentCategories();
    List<GrandParentCategory>getGrandParentCategories();

    ResponseEntity<Category> saveCategory(Category category);
    ResponseEntity<ParentCategory> saveParentCategory(ParentCategory parentCategory);
    ResponseEntity<GrandParentCategory> saveGrandParentCategory(GrandParentCategory grandParentCategory);

    List<Product> getProducts();
    Product getProductById(String productId);
    ResponseEntity<Product> updateProduct(Product product);
    ResponseEntity<Product> saveProduct(Product product);
    ResponseEntity<Product> deleteProduct(String productId);


}
