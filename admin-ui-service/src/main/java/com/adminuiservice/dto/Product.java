package com.adminuiservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    private String id;
    private String productTitle;
    private String categoryTitle;
    private String productDescription;
    private String productImagePath;
    private double productPrice;

}
