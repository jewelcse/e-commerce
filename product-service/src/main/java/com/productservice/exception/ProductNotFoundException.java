package com.productservice.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException{


    public ProductNotFoundException(String msg){
        super(msg);
    }

}
