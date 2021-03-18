package com.categoryservice.service;


import com.categoryservice.entity.ParentCategory;
import com.categoryservice.repository.ParentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentCategoryService {

    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    public void saveGrandParentCategory(ParentCategory pc) {
        parentCategoryRepository.save(pc);
    }

    public List<ParentCategory> fetchAllParentCategory() {
        return parentCategoryRepository.findAll();
    }

    public Optional<ParentCategory> fetchSingleParentCategory(Long id) {
        return parentCategoryRepository.findById(id);
    }

    public void remove(ParentCategory pc) {
        parentCategoryRepository.delete(pc);
    }
}
