package com.adminuiservice.service;

import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {


    @Autowired
    private RestTemplate template;

    @Autowired
    private AdminServiceImp adminServiceImp;

    public Map<String, Boolean> storeProduct(Product product){

        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        ResponseEntity responseEntity
                = adminServiceImp.saveProduct(product);

        System.out.println(responseEntity);

        if (responseEntity.getStatusCode() != HttpStatus.OK){
            response.put("status",false);
        }

        return response;
    }


    public List<Product> fetchAllProduct() {

        List<Product> products = adminServiceImp.getProducts();

        return products;
    }

    public Map<String, Boolean> removeProduct(String id) {

        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        ResponseEntity<Product> responseEntity
                = adminServiceImp.deleteProduct(id);

        System.out.println(responseEntity);

        if (responseEntity.getStatusCode() != HttpStatus.OK){
            response.put("status",false);
        }

        return response;
    }

    public List<Categories> getCategories() {
        List<Categories> categories = adminServiceImp.getCategories();
        return categories;
    }
}
