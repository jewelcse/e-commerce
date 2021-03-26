package com.adminuiservice.service;

import com.adminuiservice.dto.GrandParentCategory;
import org.springframework.http.ResponseEntity;

public interface GrandParentCategoryService {

    ResponseEntity<GrandParentCategory> save(GrandParentCategory grandParentCategory);

}
