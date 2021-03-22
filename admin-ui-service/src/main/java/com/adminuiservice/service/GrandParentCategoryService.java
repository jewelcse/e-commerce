package com.adminuiservice.service;


import com.adminuiservice.dto.GrandParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class GrandParentCategoryService {

    @Autowired
    private AdminServiceImp adminServiceImp;

    public Map<String,Boolean> save(GrandParentCategory grandParentCategory) {

        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        ResponseEntity<GrandParentCategory> responseEntity
                = adminServiceImp.saveGrandParentCategory(grandParentCategory);

        System.out.println(responseEntity);

        if (responseEntity.getStatusCode() != HttpStatus.OK){
            response.put("status",false);
        }

        return response;

    }
}
