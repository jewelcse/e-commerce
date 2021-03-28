package com.adminuiservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    private String id;
    private String productTitle;
    private Category category;
    private String productDescription;
    private String productImagePath;
    private double productPrice;

}
