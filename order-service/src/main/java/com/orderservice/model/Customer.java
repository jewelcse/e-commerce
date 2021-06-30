package com.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private Long mobileNumber;
    private String customerEmail;
    private String accountNumber;
    private List<Address> address;
}
