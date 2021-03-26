package com.adminuiservice.service;

import com.adminuiservice.config.ProductConfig;
import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {


    @Autowired
    private AdminServiceImp adminServiceImp;

    public Map<String, Boolean> storeProduct(Product product){

        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        adminServiceImp.saveProduct(product);
//        rabbitTemplate.convertAndSend(ProductConfig.PRODUCT_EXCHANGE,
//                ProductConfig.PRODUCT_ROUTING_KEY, product);

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

    @HystrixCommand(fallbackMethod = "getFallBackCategories")
    public List<Categories> getCategories() {
        List<Categories> categories = adminServiceImp.getCategories();
        return categories;
    }

    public List<Categories> getFallBackCategories(){
        List<Categories> categories = new ArrayList<>();
        return categories;
    }


    public Product getSingleProduct(String productId) {
        return adminServiceImp.getProductById(productId);
    }

    public Map<String, Boolean> updateProduct(Product product) {

        Map<String, Boolean> response = new HashMap<>();
        response.put("status",true);

        ResponseEntity<Product> responseEntity
                = adminServiceImp.updateProduct(product);

        System.out.println(responseEntity);

        if (responseEntity.getStatusCode() != HttpStatus.OK){
            response.put("status",false);
        }

        return response;
    }
}
