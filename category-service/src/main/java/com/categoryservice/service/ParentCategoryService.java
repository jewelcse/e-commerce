package com.categoryservice.service;


import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.entity.ParentCategory;
import com.categoryservice.repository.ParentCategoryRepository;
import com.categoryservice.request.ParentCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ParentCategoryService {

    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    public void saveParentCategory(ParentCategoryDto pcd) {

        ParentCategory parentCategory = new ParentCategory();
        parentCategory.setParentCategoryTitle(pcd.getParentCategoryTitle());

        GrandParentCategory gpc = new GrandParentCategory();
        gpc.setId(pcd.getGrandParentCategoryId());
        parentCategory.setGrandParentCategory(gpc);
        // save to database
        parentCategoryRepository.save(parentCategory);

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

    public void updateParentCategory(ParentCategory parentCategory) {

        parentCategoryRepository.save(parentCategory);
        System.out.println(" service "+ parentCategory);
    }
}
