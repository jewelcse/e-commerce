package com.orderservice.dto;

import com.orderservice.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @Id
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private Long mobileNumber;
    private String AccountNumber;
    private double credits;

}
