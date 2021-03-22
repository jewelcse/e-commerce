package com.adminuiservice.service;


import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService{

    @Autowired
    private AdminServiceImp adminServiceImp;

    public List<ParentCategory> fetchAllParentCategories() {

        List<ParentCategory> parentCategories
                = adminServiceImp.getParentCategories();

        return parentCategories;
    }

    public Map<String, Boolean> save(Category category) {


        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        ResponseEntity<Category> responseEntity = adminServiceImp.saveCategory(category);
        System.out.println(responseEntity);

        if (responseEntity.getStatusCode() != HttpStatus.OK){
            response.put("status",false);
        }

        return response;

    }
}
