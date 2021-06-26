package com.orderservice.service;

import com.orderservice.config.OrderConfig;
import com.orderservice.dto.OrderDto;
import com.orderservice.model.Order;
import com.orderservice.model.Product;
import com.orderservice.repository.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private RabbitTemplate rabbitTemplate;
    private OrderDto orderDto;


    public OrderServiceImpl(OrderRepository orderRepository,
                            RabbitTemplate rabbitTemplate){
        this.orderRepository = orderRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Order saveOrder(Order order) {

        List<Product> products= order.getProducts();

        double totalCost = products.stream().mapToDouble(product -> product.getProductPrice() * product.getQuantity()).sum();

        Integer totalQuantity = products.stream().mapToInt( product -> product.getQuantity()).sum();

        order.setStatus(Order.OrderStatus.PROCESSING);
        order.setTotalCost(totalCost);
        order.setQuantity(totalQuantity);

        paymentPublish(order);
        //System.out.println(order);
        return orderRepository.save(order);
    }

    private void paymentPublish(Order order) {

        orderDto = new OrderDto();
        orderDto.setCustomerId(order.getCustomer().getCustomerId());
        orderDto.setAccountNumber(order.getCustomer().getAccountNumber());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setCost(order.getTotalCost());


        rabbitTemplate.convertAndSend(OrderConfig.ORDER_EXCHANGE,OrderConfig.ORDER_ROUTING_KEY,orderDto);

    }
}
