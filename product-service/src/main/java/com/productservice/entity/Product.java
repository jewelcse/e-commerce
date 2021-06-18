package com.productservice.entity;


import com.productservice.dto.Category;
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
    private Category category;
    private String productDescription;
    private byte[] productImagePath;
    private double productPrice;


}
