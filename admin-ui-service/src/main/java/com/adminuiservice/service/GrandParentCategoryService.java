package com.adminuiservice.service;

import com.adminuiservice.dto.GrandParentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GrandParentCategoryService {

    GrandParentCategory save(GrandParentCategory grandParentCategory);
    List<GrandParentCategory> getAllGrandParentCategories();
    void removeGrandParentCategory(Long id);
    GrandParentCategory updateGrandParentCategory(Long id);
    GrandParentCategory getGrandParentCategoryById(Long id);

}
