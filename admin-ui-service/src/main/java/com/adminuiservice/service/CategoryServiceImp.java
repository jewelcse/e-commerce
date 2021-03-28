package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.ParentCategory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class CategoryServiceImp  implements CategoryService{

    @Autowired
    private RestTemplate template;

    @HystrixCommand(fallbackMethod = "getFallBackCategories")
    @Override
    public List<Categories> getCategories() {
        ResponseEntity<Categories[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_CATEGORIES_URL,Categories[].class);

        List<Categories> categories = Arrays.asList(responseEntity.getBody());

        return categories;
    }

    @Override
    public Category getCategoryByTitle(String categoryTitle) {
        return template.getForObject(RequestURLS.FETCH_CATEGORY_BY_TITLE_URL+categoryTitle,Category.class);
    }

    @Override
    public List<Categories> getFallBackCategories(){
        List<Categories> categories = new ArrayList<>();
        return categories;
    }

    @HystrixCommand(fallbackMethod = "fetchFallbackAllParentCategories")
    public List<ParentCategory> fetchAllParentCategories() {

        ResponseEntity<ParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_PARENT_CATEGORIES_URL,ParentCategory[].class);

        List<ParentCategory> parentCategories
                = Arrays.asList(responseEntity.getBody());

        return parentCategories;
    }

    private List<ParentCategory> fetchFallbackAllParentCategories(){
        List<ParentCategory> parentCategories = new ArrayList<>();
        return parentCategories;
    }

    public ResponseEntity<Category> save(Category category) {

        try {

            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // set request
            HttpEntity<Category> request
                    = new HttpEntity<>(category, headers);


            // post request
            ResponseEntity<Category> responseEntity
                    = template.postForEntity(RequestURLS.CATEGORY_STORE_URL, request, Category.class);

            HttpStatus status = responseEntity.getStatusCode();

            if (status == HttpStatus.OK) {
                return responseEntity;
            }

        }catch (HttpStatusCodeException e){
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            }
            throw e;
        }
        return null;

    }
}
