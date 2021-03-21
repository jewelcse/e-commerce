package com.categoryservice.service;


import com.categoryservice.entity.Category;
import com.categoryservice.entity.ParentCategory;
import com.categoryservice.repository.CategoryRepository;
import com.categoryservice.request.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(CategoryDto c) {
        Category category = new Category();
        category.setCategoryTitle(c.getCategoryTitle());

        ParentCategory parentCategory = new ParentCategory();
        parentCategory.setId(c.getParentCategoryId());

        category.setParentCategory(parentCategory);
        categoryRepository.save(category);
    }

    public List<Category> fetchAllCategory() {
        return categoryRepository.findAll();
    }

    public Optional<Category> fetchSingleCategory(Long id) {

        return categoryRepository.findById(id);
    }

    public void remove(Category c) {
        categoryRepository.delete(c);
    }
}
