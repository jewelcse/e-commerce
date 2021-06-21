package com.customerservice.controller;


import com.customerservice.exception.CustomerNotFoundException;
import com.customerservice.model.Customer;
import com.customerservice.service.CustomerServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class CustomerController {


    private CustomerServiceImp customerServiceImp;

    public CustomerController(CustomerServiceImp customerServiceImp){
        this.customerServiceImp = customerServiceImp;
    }

    @PostMapping("/save-customer")
    public ResponseEntity<Customer> createOrUpdateCustomer(@RequestBody Customer customer) throws RuntimeException{
        return new ResponseEntity<>(customerServiceImp.saveOrUpdateCustomer(customer),HttpStatus.OK);
    }

    @GetMapping("/remove-customer")
    public void deleteCustomer(@RequestParam String id){

        Customer customer = customerServiceImp.findCustomerById(id)
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found for "+id));

        customerServiceImp.removeCustomer(customer.getCustomerId());

    }

    @GetMapping("/get-customer")
    public ResponseEntity<Customer> getCustomer(@RequestParam String id) throws RuntimeException{
        Customer customer = customerServiceImp.findCustomerById(id)
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found for "+id));

        return new ResponseEntity<>(customer,HttpStatus.OK);
    }





}
