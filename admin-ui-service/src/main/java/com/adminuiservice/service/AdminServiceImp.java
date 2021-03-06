package com.adminuiservice.service;

import com.adminuiservice.common.AdminService;
import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.*;
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
public class AdminServiceImp implements AdminService {

    @Autowired
    private RestTemplate template;

    @Override
    public List<Categories> getCategories() {

        ResponseEntity<Categories[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_CATEGORIES_URL,Categories[].class);

        List<Categories> categories = Arrays.asList(responseEntity.getBody());

        return categories;
    }

    @Override
    public List<ParentCategory> getParentCategories() {

        ResponseEntity<ParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_PARENT_CATEGORIES_URL,ParentCategory[].class);

        List<ParentCategory> parentCategories
                = Arrays.asList(responseEntity.getBody());

        return parentCategories;
    }

    @Override
    public List<GrandParentCategory> getGrandParentCategories() {

        ResponseEntity<GrandParentCategory[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_GRAND_PARENT_CATEGORIES_URL,GrandParentCategory[].class);

        List<GrandParentCategory> grandParentCategories = Arrays.asList(responseEntity.getBody());


        return grandParentCategories;
    }

    @Override
    public List<Product> getProducts() {

        ResponseEntity<Product[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_PRODUCTS_URL, Product[].class);

        List<Product> products = Arrays.asList(responseEntity.getBody());

        return products;
    }

    @Override
    public Product getProductById(String productId) {
        ResponseEntity<Product> responseEntity = template.getForEntity(RequestURLS.FETCH_SINGLE_PRODUCT_URL+productId,Product.class);

        Product product = responseEntity.getBody();

        return product;
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product product) {

        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("id",product.getId());

        try {

            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // set request
            HttpEntity<Product> request
                    = new HttpEntity<>(product, headers);


            // post request
            ResponseEntity<Product> responseEntity
                    = template.postForEntity(RequestURLS.PRODUCT_UPDATE_URL, request, Product.class,uriParams);

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
    public ResponseEntity<Category> saveCategory(Category category) {

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
    public ResponseEntity<ParentCategory> saveParentCategory(ParentCategory parentCategory) {

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
    public ResponseEntity<GrandParentCategory> saveGrandParentCategory(GrandParentCategory grandParentCategory) {

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

    @Override
    public ResponseEntity<Product> saveProduct(Product product) {

        try{
            // set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // set request body with headers
            HttpEntity<Product> request =
                    new HttpEntity<>(product,headers);

            // post request
            ResponseEntity<Product> responseEntity
                    = template.postForEntity(RequestURLS.PRODUCT_STORE_URL, request, Product.class);

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
    public ResponseEntity<Product> deleteProduct(String productId) {

        try {

            ResponseEntity<Product> productResponseEntity
                    = template.getForEntity(RequestURLS.PRODUCT_REMOVE_URL+productId,Product.class);

            HttpStatus status = productResponseEntity.getStatusCode();

            if (status == HttpStatus.OK) {
                return productResponseEntity;
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
