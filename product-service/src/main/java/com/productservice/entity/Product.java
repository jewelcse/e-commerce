package com.productservice.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    private String productId;
    private String productTitle;
    private Category category;
    private String productDescription;
    private String productImagePath;
    private double productPrice;


}
