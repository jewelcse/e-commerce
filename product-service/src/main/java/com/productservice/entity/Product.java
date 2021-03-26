package com.productservice.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String productTitle;
    private String categoryTitle;
    private String productDescription;
    private String productImagePath;
    private double productPrice;


}
