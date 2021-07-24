package com.orderservice.controller;


import com.orderservice.exception.OrderNotFoundException;
import com.orderservice.model.Address;
import com.orderservice.model.Customer;
import com.orderservice.model.Order;
import com.orderservice.model.Product;
import com.orderservice.service.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class OrderController {

    private OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderServiceImpl){
        this.orderService = orderServiceImpl;
    }


    @PostMapping("/order-create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("order")
    public ResponseEntity<Optional<Order>> getOrderById(@RequestParam String id){

        Order order = orderService.getOrder(id)
                .orElseThrow(()-> new OrderNotFoundException("Order Not Found for Id"+id));

        return new ResponseEntity<>(Optional.of(order),HttpStatus.OK);
    }


}
