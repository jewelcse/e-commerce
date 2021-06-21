package com.customerservice.controller;


import com.customerservice.exception.CustomerNotFoundException;
import com.customerservice.model.Address;
import com.customerservice.model.Customer;
import com.customerservice.service.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {


    @Autowired
    private CustomerServiceImp customerServiceImp;

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws RuntimeException{
        return new ResponseEntity<>(customerServiceImp.saveCustomer(customer),HttpStatus.OK);
    }

    @GetMapping("/remove-customer")
    public void deleteCustomer(@RequestParam String id){

        Customer customer = customerServiceImp.findCustomerById(id)
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found for "+id));

        customerServiceImp.removeCustomer(customer.getCustomerId());

    }





}
