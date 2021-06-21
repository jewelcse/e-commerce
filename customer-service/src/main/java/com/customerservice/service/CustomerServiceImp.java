package com.customerservice.service;

import com.customerservice.model.Customer;
import com.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
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
