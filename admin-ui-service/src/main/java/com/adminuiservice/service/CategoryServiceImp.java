package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.GrandParentCategory;
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
    public List<Category> getCategories() {
        ResponseEntity<Category[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_CATEGORIES_URL,Category[].class);

        List<Category> categories = Arrays.asList(responseEntity.getBody());

        return categories;
    }

    //@HystrixCommand(fallbackMethod = "getFallbackCategoryByTitle")
    @Override
    public Category getCategoryByTitle(String categoryTitle) {
        return template.getForObject(RequestURLS.FETCH_CATEGORY_BY_TITLE_URL+categoryTitle,Category.class);
    }

    private Category getFallbackCategoryByTitle(){

        Category category = new Category();
        category.setCategoryTitle("Service is Down");

        ParentCategory parentCategory = new ParentCategory();
        parentCategory.setParentCategoryTitle("Service is Down");

        GrandParentCategory grandParentCategory = new GrandParentCategory();
        grandParentCategory.setGrandParentCategoryTitle("Service is Down");

        parentCategory.setGrandParentCategory(grandParentCategory);
        category.setParentCategory(parentCategory);

        return category;
    }
    @Override
    public List<Category> getFallBackCategories(){
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        ParentCategory parentCategory = new ParentCategory();
        parentCategory.setParentCategoryTitle("Service is down");

        GrandParentCategory grandParentCategory = new GrandParentCategory();
        grandParentCategory.setGrandParentCategoryTitle("Service is down");

        parentCategory.setGrandParentCategory(grandParentCategory);

        category.setCategoryTitle("Service is Down");
        category.setParentCategory(parentCategory);
        categories.add(category);
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


    @Override
    public void removeCategory(int id) {

         template.getForEntity(RequestURLS.CATEGORY_REMOVE_URL+id,Category.class);

    }

    @Override
    public Category getCategoryById(Long id) {

        ResponseEntity<Category> responseEntity =
                template.getForEntity(RequestURLS.FETCH_CATEGORY_BY_ID+id,Category.class);

        Category category = responseEntity.getBody();

        return category;
    }

    @Override
    public ResponseEntity<Category> update(Category category) {

       try{
           // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set request
        HttpEntity<Category> request
                = new HttpEntity<>(category, headers);


        // post request
        ResponseEntity<Category> responseEntity
                = template.postForEntity(RequestURLS.UPDATE_CATEGORY+category.getId(), request, Category.class);

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
