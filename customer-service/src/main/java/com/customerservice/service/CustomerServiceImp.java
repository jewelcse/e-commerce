package com.customerservice.service;

import com.customerservice.model.Customer;
import com.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
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
