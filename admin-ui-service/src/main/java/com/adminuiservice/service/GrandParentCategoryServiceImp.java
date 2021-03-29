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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GrandParentCategoryServiceImp implements GrandParentCategoryService {

    @Autowired
    private RestTemplate template;

    //@HystrixCommand(fallbackMethod = "saveFallbackForGrandParentCategory")
    @Override
    public GrandParentCategory save(GrandParentCategory grandParentCategory) {

        try{
            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // set request body with headers
            HttpEntity<GrandParentCategory> request =
                    new HttpEntity<>(grandParentCategory,headers);


            ResponseEntity<GrandParentCategory> responseEntity
                    = template.postForEntity(RequestURLS.GRAND_PARENT_CATEGORY_STORE_URL,request,GrandParentCategory.class);

            HttpStatus status = responseEntity.getStatusCode();

            System.out.println("body"+responseEntity.getBody());
            if (status == HttpStatus.OK) {
                return responseEntity.getBody();
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
    public List<GrandParentCategory> getAllGrandParentCategories() {

        ResponseEntity<GrandParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_GRAND_PARENT_CATEGORIES_URL,GrandParentCategory[].class);

        List<GrandParentCategory> grandParentCategories
                = Arrays.asList(responseEntity.getBody());

        return grandParentCategories;
    }

    @Override
    public void removeGrandParentCategory(Long id) {

        template.getForEntity(RequestURLS.GRAND_PARENT_CATEGORY_REMOVE_URL+id, GrandParentCategory.class);

    }

    @Override
    public GrandParentCategory updateGrandParentCategory(Long id) {

        return null;
    }

    @Override
    public GrandParentCategory getGrandParentCategoryById(Long id) {

        ResponseEntity<GrandParentCategory> grandParentCategory =
                template.getForEntity(RequestURLS.FETCH_GRAND_PARENT_CATEGORY_BY_ID+id, GrandParentCategory.class);

        return grandParentCategory.getBody();
    }

    private GrandParentCategory saveFallbackForGrandParentCategory(){

        return new GrandParentCategory(-1L,"Service is Down");
    }
}
