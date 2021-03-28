package com.adminuiservice.service;

import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Categories> getCategories();
    Category getCategoryByTitle(String categoryTitle);
    List<Categories> getFallBackCategories();
    List<ParentCategory> fetchAllParentCategories();
    ResponseEntity<Category> save(Category category);
}
