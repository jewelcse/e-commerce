package com.ecomoderservice.controller;

import com.ecomoderservice.entity.Customer;
import com.ecomoderservice.entity.Order;
import com.ecomoderservice.entity.Product;
import com.ecomoderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    // customer make order endpoint -{user-part}
    @PostMapping("/create")
    public String createOrder(){
        ArrayList<Product> productList = new ArrayList<Product>();
        Product product1 = new Product(11L,"product111","prodes111",11.3,11);
        Product product2 = new Product(22L,"product222","prodes222",22.3,22);
        Product product3 = new Product(33L,"product333","prodes333",33.3,33);
        Customer customer = new Customer(111L,"Jewel","Chowdhury","jewel@gmail.com",1092217L);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        System.out.println("[OrderController: ]"+productList);
        Order order = orderService.saveOrder(productList,customer,"shippingAddress");
        return order.toString();
    }

    // get all customer orders endpoint - {user-part}
    @GetMapping("/customer/orders")
    public ArrayList<Order> getCustomerOrders(@RequestParam Long id){
        return orderService.fetchOrderByCustomerId(id);
    }

    // get customer single order endpoint - {user-part}
    @GetMapping("/order")
    public Optional<Order> getOrder(@RequestParam String orderId){
        return orderService.fetchOrderByOrderId(orderId);
    }

    // customer cancel order endpoint -{user-part}
    @DeleteMapping("/order/cancel")
    public void removeOrder(@RequestParam String orderId){
        orderService.cancelOrder(orderId);
    }


    // get all orders endpoint- {admin-part}
    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.fetchAllOrder();
    }

    // admin remove order endpoint -{admin-part}
    @DeleteMapping("/order/remove")
    public void removeOrderByAdmin(@RequestParam String orderId){
        orderService.cancelOrder(orderId);
    }




}
