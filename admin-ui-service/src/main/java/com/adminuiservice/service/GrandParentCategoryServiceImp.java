package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.GrandParentCategory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;


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

    private GrandParentCategory saveFallbackForGrandParentCategory(){

        return new GrandParentCategory(-1L,"Service is Down");
    }
}
