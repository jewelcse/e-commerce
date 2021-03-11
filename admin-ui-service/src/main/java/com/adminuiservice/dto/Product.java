package com.adminuiservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    private String productTitle;
    private Category category;
    private String productDescription;
    private String productImage;
    private double productPrice;

}
