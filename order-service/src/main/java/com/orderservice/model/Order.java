package com.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    private String id;

	private List<Product> products;
	
	private Customer customer;

    private int quantity;

    private double value;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        PROCESSING, COMPLETED, CANCELED
    }

}