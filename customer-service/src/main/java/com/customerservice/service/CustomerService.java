package com.customerservice.service;

import com.customerservice.model.Customer;

import java.util.Optional;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);
    public void removeCustomer(String id);
    public Optional<Customer> findCustomerById(String id);
}
