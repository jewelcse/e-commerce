package com.adminuiservice.service;


import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.GrandParentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GrandParentCategoryService implements RequestURLS {

    @Autowired
    private RestTemplate template;

    public Map<String,Boolean> save(GrandParentCategory grandParentCategory) {


        Map<String, Boolean> response = new HashMap<>();

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set request body with headers
        HttpEntity<GrandParentCategory> request =
                new HttpEntity<>(grandParentCategory,headers);


        ResponseEntity<GrandParentCategory> responseEntity
                = template.postForEntity(RequestURLS.GRAND_PARENT_CATEGORY_STORE_URL,request,GrandParentCategory.class);


        // old code structure
        //GrandParentCategory response = template.postForObject("http://localhost:8100/grand-parent-category/create",request, GrandParentCategory.class);

        //System.out.println(responseEntity.getStatusCode());
        //assertThat(response.getStatusCode(), is(HttpStatus.CREATED));

        if (responseEntity.getStatusCode().equals(200)){
            response.put("status",true);
        }else {
            response.put("status",false);
        }
        return response;

    }
}
