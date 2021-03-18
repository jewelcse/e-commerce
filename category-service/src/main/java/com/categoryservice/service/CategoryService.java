package com.categoryservice.service;


import com.categoryservice.entity.Category;
import com.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(Category c) {
        categoryRepository.save(c);
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
