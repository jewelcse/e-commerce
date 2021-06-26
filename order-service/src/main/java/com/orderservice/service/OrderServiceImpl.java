package com.orderservice.service;

import com.orderservice.dto.CustomerDto;
import com.orderservice.model.Customer;
import com.orderservice.model.Order;
import com.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

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

        customerDto = new CustomerDto();
        customerDto.setCredits(1000.00);
        double credits = customerDto.getCredits();

        if(order.getValue()<credits){
            order.setStatus(Order.OrderStatus.COMPLETED);
        }else {
            order.setStatus(Order.OrderStatus.PROCESSING);
        }
        return orderRepository.save(order);
    }
}
