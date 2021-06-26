package com.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {

    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private Long mobileNumber;
    private String AccountNumber;
    private double credits;

}
