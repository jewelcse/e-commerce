package com.productservice.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubCategory3 {

    private String id;
    private String subCategory3Title;

}
