package com.adminuiservice.service;

import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParentCategoryService {

    ResponseEntity<ParentCategory> save(ParentCategory parentCategory);
    List<GrandParentCategory> fetchAllGrandParentCategories();
}
