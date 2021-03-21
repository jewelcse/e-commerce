package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class ParentCategoryService implements RequestURLS {



    @Autowired
    private RestTemplate template;

    public Map<String,Boolean> save(ParentCategory parentCategory) {


        Map<String, Boolean> response = new HashMap<>();

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set request body with headers
        HttpEntity<ParentCategory> request =
                new HttpEntity<>(parentCategory,headers);


        // post request
        ResponseEntity<ParentCategory> responseEntity
                = template.postForEntity(RequestURLS.PARENT_CATEGORY_STORE_URL,request,ParentCategory.class);


        if (responseEntity.getStatusCode().equals(200)){
            response.put("status",true);
        }else {
            response.put("status",false);
        }
        return response;

    }

    public List<GrandParentCategory> fetchAllGrandParentCategories(){

        ResponseEntity<GrandParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_GRAND_PARENT_CATEGORIES_URL,GrandParentCategory[].class);

        List<GrandParentCategory> categoryList = Arrays.asList(responseEntity.getBody());

        return categoryList;
    }
}
