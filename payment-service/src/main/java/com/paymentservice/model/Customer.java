package com.paymentservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private Long mobileNumber;
    private String AccountNumber;
}
