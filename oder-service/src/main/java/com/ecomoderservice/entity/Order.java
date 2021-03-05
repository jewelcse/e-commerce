package com.ecomoderservice.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Order {
    @Id
    private String orderId;
    private ArrayList<Product> productList;
    private Customer customer;
    private String shippingAddress;
    private Date orderDate;
    private Boolean orderStatusCode; // cancel or completed


    public Order() {
    }

    public Order(ArrayList<Product> productList, Customer customer, String shippingAddress) {
        this.productList = productList;
        this.customer = customer;
        this.shippingAddress = shippingAddress;
    }

    public List<Product> getProduct() {
        return productList;
    }

    public void setProduct(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productList=" + productList +
                ", customer=" + customer +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}
