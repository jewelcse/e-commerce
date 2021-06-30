package com.customerservice.service;

import com.customerservice.configuration.NotificationConfig;
import com.customerservice.model.Customer;
import com.customerservice.model.Notification;
import com.customerservice.repository.CustomerRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;
    private RabbitTemplate rabbitTemplate;


    public CustomerServiceImp(CustomerRepository customerRepository,RabbitTemplate rabbitTemplate){
        this.customerRepository = customerRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {

        String id = UUID.randomUUID().toString();
        customer.setCustomerId(id);
        customerRepository.save(customer);
        sendNotification(customer);
        return customer;
    }

    private void sendNotification(Customer customer){

        String notificationId = UUID.randomUUID().toString();

        Notification notification = new Notification();
        notification.setNotificationId(notificationId);
        notification.setCustomerId(customer.getCustomerId());
        notification.setNotificationMessage("Registration successful for "
                +customer.getCustomerFirstName() + " "
                +customer.getCustomerLastName());

        rabbitTemplate.convertAndSend(NotificationConfig.NOTIFICATION_EXCHANGE,
                NotificationConfig.NOTIFICATION_ROUTING_KEY, notification);


    }

    @Override
    public void removeCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return customerRepository.findById(id);
    }
}
