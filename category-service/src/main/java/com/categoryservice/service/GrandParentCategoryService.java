package com.categoryservice.service;


import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.repository.GrandParentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrandParentCategoryService {

    @Autowired
    private GrandParentCategoryRepository grandParentCategoryRepository;

    public void saveGrandParentCategory(GrandParentCategory gpc) {
        grandParentCategoryRepository.save(gpc);
    }


    public List<GrandParentCategory> fetchAllGrandParentCategory() {
        return grandParentCategoryRepository.findAll();
    }

    public Optional<GrandParentCategory> fetchSingleGrandParentCategory(Long id) {
        return grandParentCategoryRepository.findById(id);
    }

    public void remove(GrandParentCategory gp) {
         grandParentCategoryRepository.delete(gp);
    }


}
