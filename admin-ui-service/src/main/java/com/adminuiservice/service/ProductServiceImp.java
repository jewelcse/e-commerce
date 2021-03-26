package com.adminuiservice.service;

import com.adminuiservice.common.RequestURLS;
import com.adminuiservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProductServiceImp implements ProductService{


    @Autowired
    private RestTemplate template;



    @Override
    public ResponseEntity<Product> storeProduct(Product product){

        return getProductResponseEntity(product, template);

    }

    static ResponseEntity<Product> getProductResponseEntity(Product product, RestTemplate template) {
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
    public List<Product> fetchAllProduct() {

        ResponseEntity<Product[]> responseEntity
                = template.getForEntity(RequestURLS.FETCH_PRODUCTS_URL, Product[].class);

        List<Product> products = Arrays.asList(responseEntity.getBody());

        return products;

    }
    @Override
    public ResponseEntity<Product> removeProduct(String productId) {

        return getProductResponseEntity(productId, template);
    }

    static ResponseEntity<Product> getProductResponseEntity(String productId, RestTemplate template) {
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


    @Override
    public Product getSingleProduct(String productId) {
        ResponseEntity<Product> responseEntity = template.getForEntity(RequestURLS.FETCH_SINGLE_PRODUCT_URL+productId,Product.class);

        Product product = responseEntity.getBody();

        return product;
    }


    @Override
    public void updateProduct(Product product) {

        Map<String, String> urlParams = new HashMap<>();
        urlParams.put("id",product.getId());

        // set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // set request
        HttpEntity<Product> request
                = new HttpEntity<>(product, headers);


        // post request
        ResponseEntity<Product> responseEntity
                = template.postForEntity(RequestURLS.PRODUCT_UPDATE_URL, request, Product.class,urlParams);

        HttpStatus status = responseEntity.getStatusCode();

    }
}
