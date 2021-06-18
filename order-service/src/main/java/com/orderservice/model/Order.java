package com.orderservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Document
@NoArgsConstructor
@Data
public class Order {

    @Id
    private Long id;

	private List<Product> productsList;
	
	private Customer customer;

    private Long quantity;

    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public enum OrderStatus {
        PROCESSING, COMPLETED, CANCELED
    }

}