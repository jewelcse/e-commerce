package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import com.adminuiservice.dto.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class ParentCategoryServiceImp implements ParentCategoryService{

    @Autowired
    private RestTemplate template;

    @Override
    public ResponseEntity<ParentCategory> save(ParentCategory parentCategory) {

        return getParentCategoryResponseEntity(parentCategory, template);
    }

    static ResponseEntity<ParentCategory> getParentCategoryResponseEntity(ParentCategory parentCategory, RestTemplate template) {
        try {

            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // set request body with headers
            HttpEntity<ParentCategory> request =
                    new HttpEntity<>(parentCategory, headers);


            // post request
            ResponseEntity<ParentCategory> responseEntity
                    = template.postForEntity(RequestURLS.PARENT_CATEGORY_STORE_URL, request, ParentCategory.class);

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

    @Override
    @HystrixCommand(fallbackMethod = "fetchFallbackAllGrandParentCategories")
    public List<GrandParentCategory> fetchAllGrandParentCategories(){

        ResponseEntity<GrandParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_GRAND_PARENT_CATEGORIES_URL,GrandParentCategory[].class);

        List<GrandParentCategory> grandParentCategories = Arrays.asList(responseEntity.getBody());

        return grandParentCategories;
    }

    @Override
    public List<ParentCategory> fetchAllParentCategories() {
        ResponseEntity<ParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_PARENT_CATEGORIES_URL,ParentCategory[].class);

        List<ParentCategory> parentCategories = Arrays.asList(responseEntity.getBody());

        return parentCategories;
    }

    @Override
    public ParentCategory getParentCategoryById(Long id) {
        ResponseEntity<ParentCategory> responseEntity = template.getForEntity(RequestURLS.FETCH_PARENT_CATEGORY_BY_ID+id,ParentCategory.class);

        ParentCategory parentCategory = responseEntity.getBody();

        return parentCategory;
    }

    @Override
    public ResponseEntity<ParentCategory> update(ParentCategory parentCategory) {

        try{
        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set request body with headers
        HttpEntity<ParentCategory> request =
                new HttpEntity<>(parentCategory, headers);


        // post request
        ResponseEntity<ParentCategory> responseEntity
                = template.postForEntity(RequestURLS.UPDATE_PARENT_CATEGORY+parentCategory.getId(), request, ParentCategory.class);

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

    private List<GrandParentCategory> fetchFallbackAllGrandParentCategories(){
        List<GrandParentCategory> grandParentCategories = new ArrayList<>();
        return grandParentCategories;
    }
}
