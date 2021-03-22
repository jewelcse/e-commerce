package com.adminuiservice.common;

import com.adminuiservice.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    List<Categories> getCategories();
    List<ParentCategory> getParentCategories();
    List<GrandParentCategory>getGrandParentCategories();
    List<Product> getProducts();

    ResponseEntity<Category> saveCategory(Category category);
    ResponseEntity<ParentCategory> saveParentCategory(ParentCategory parentCategory);
    ResponseEntity<GrandParentCategory> saveGrandParentCategory(GrandParentCategory grandParentCategory);


}
