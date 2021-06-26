package com.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private Long mobileNumber;
    private String customerEmail;
    private List<Address> address;
}
