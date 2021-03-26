package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.GrandParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


@Service
public class GrandParentCategoryServiceImp implements GrandParentCategoryService {

    @Autowired
    private RestTemplate template;

    @Override
    public ResponseEntity<GrandParentCategory> save(GrandParentCategory grandParentCategory) {

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
