package com.orderservice.service;

import com.orderservice.dto.CustomerDto;
import com.orderservice.model.Customer;
import com.orderservice.model.Order;
import com.orderservice.model.Product;
import com.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private CustomerDto customerDto;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {

        Customer customer = order.getCustomer();

        String id = customer.getCustomerId();
        // check payment by id

        List<Product> products= order.getProducts();

        double totalCost = products.stream().mapToDouble(product -> product.getProductPrice() * product.getQuantity()).sum();

        Integer totalQuantity = products.stream().mapToInt( product -> product.getQuantity()).sum();
        order.setValue(totalCost);
        order.setQuantity(totalQuantity);

        customerDto = new CustomerDto();
        customerDto.setCredits(200.00);

        double credits = customerDto.getCredits();

        order.setStatus(Order.OrderStatus.PROCESSING);

        if(order.getValue()<credits){
            order.setStatus(Order.OrderStatus.COMPLETED);
        }else {
            order.setStatus(Order.OrderStatus.CANCELED);
        }
        return orderRepository.save(order);
    }
}
