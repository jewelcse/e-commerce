package com.productservice.service;

import com.productservice.entity.Category;
import com.productservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // save category
    public Category saveCategory(Category category){
      return  categoryRepository.save(category);
    }

    // fetch all category
    public List<Category> fetchAllCategory(){
        return categoryRepository.findAll();
    }

    // fetch single category
    public Optional<Category> fetchSingleCategory(String categoryId){
        return categoryRepository.findById(categoryId);
    }

    // remove category
    public void removeCategory(String categoryId){
        categoryRepository.deleteById(categoryId);
    }


}
