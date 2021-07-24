package com.productservice.entity;


import com.productservice.dto.Category;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String productTitle;
    private String productSlug;
    private String productOverview;
    private String productDescription;
    private String[] productImages;
    private Category category;
    private double productPrice;
    private double productRating;
    private Date date;
    private int discountPercentage;
    


}
