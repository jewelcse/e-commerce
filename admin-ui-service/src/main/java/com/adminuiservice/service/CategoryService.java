package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.ParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements RequestURLS {

    @Autowired
    private RestTemplate template;

    public List<ParentCategory> fetchAllParentCategories() {

        ResponseEntity<ParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_PARENT_CATEGORIES_URL,ParentCategory[].class);

        List<ParentCategory> parentCategories
                = Arrays.asList(responseEntity.getBody());

        return parentCategories;
    }

    public void save(Category category) {

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set request
        HttpEntity<Category> request
                = new HttpEntity<>(category,headers);


        // post request
        ResponseEntity<Category> responseEntity
                =template.postForEntity(RequestURLS.CATEGORY_STORE_URL,request,Category.class);

    }
}
