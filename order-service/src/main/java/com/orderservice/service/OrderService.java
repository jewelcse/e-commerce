package com.orderservice.service;

import com.orderservice.model.Order;

import java.util.Optional;

public interface OrderService {

    public Order saveOrder(Order order);
    public Optional<Order> getOrder(String id);
}
