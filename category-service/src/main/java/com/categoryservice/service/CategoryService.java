package com.categoryservice.service;

import com.categoryservice.entity.Category;
import com.categoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // fetch all category
    public List<Category> fetchAllCategory(){
        return categoryRepository.findAll();
    }
}
