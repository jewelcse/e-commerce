package com.ecomoderservice.service;

import com.ecomoderservice.entity.Customer;
import com.ecomoderservice.entity.Order;
import com.ecomoderservice.entity.Product;
import com.ecomoderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // save order
    public Order saveOrder(ArrayList<Product> productList, Customer customer, String shippingAddress){
        return orderRepository.save(new Order(productList,customer,shippingAddress));
    }

    // fetch orders
    public List<Order> fetchAllOrder(){
        return orderRepository.findAll();
    }

    // fetch orders by customer id
    public ArrayList<Order> fetchOrderByCustomerId(Long customerId){
        return orderRepository.findByCustomer_CustomerId(customerId);
    }

    // fetch order by order id
    public Optional<Order> fetchOrderByOrderId(String orderId){
        return orderRepository.findById(orderId);
    }

    // cancel order
    public void cancelOrder(String orderId){
        orderRepository.deleteById(orderId);
    }

}
