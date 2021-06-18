package com.productservice.exception;

public class ProductNotFoundException extends RuntimeException{


    public ProductNotFoundException(){}

    public ProductNotFoundException(String msg){
        super(msg);
    }

}
