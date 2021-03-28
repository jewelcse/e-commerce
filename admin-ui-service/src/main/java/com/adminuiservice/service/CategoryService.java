package com.adminuiservice.service;

import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    Category getCategoryByTitle(String categoryTitle);
    List<Category> getFallBackCategories();
    List<ParentCategory> fetchAllParentCategories();
    ResponseEntity<Category> save(Category category);

    void removeCategory(int id);
}
