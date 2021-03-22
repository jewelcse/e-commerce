package com.adminuiservice.service;


import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ParentCategoryService {

    @Autowired
    private AdminServiceImp adminServiceImp;

    public Map<String, Boolean> save(ParentCategory parentCategory) {


        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        ResponseEntity<ParentCategory> responseEntity
                = adminServiceImp.saveParentCategory(parentCategory);

        System.out.println(responseEntity);

        if (responseEntity.getStatusCode() != HttpStatus.OK){
            response.put("status",false);
        }

        return response;
    }

    public List<GrandParentCategory> fetchAllGrandParentCategories(){

        List<GrandParentCategory> grandParentCategories
                =adminServiceImp.getGrandParentCategories();

        return grandParentCategories;
    }
}
