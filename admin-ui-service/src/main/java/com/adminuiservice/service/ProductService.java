package com.adminuiservice.service;

import com.adminuiservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {


    @Autowired
    private RestTemplate template;

    public Product storeProduct(Product product){
        Product response = template.postForObject("http://localhost:8200/api/product/create",product,Product.class);
        return response;
    }


    public ResponseEntity<List<Product>> fetchAllProduct() {
        ResponseEntity<Product[]> responseEntity = template.getForEntity("http://localhost:8200/api/get/products", Product[].class);

        List<Product> products = Arrays.asList(responseEntity.getBody());

//
//        for (Product product : products) {
//            System.out.println(product);
//        }

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    public Map<String, Boolean> removeProduct(String id) {
        Map< String, String > params = new HashMap< String, String >();
        params.put("id", id);
        System.out.println("[Product Service]" + id);
        //template.getForObject("http://localhost:8200/api/remove/product",Product.class,params);
        template.getForObject("http://localhost:8200/api/remove/product?id="+id,Product.class);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
