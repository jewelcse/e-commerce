package com.productservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    private String id;
    private String categoryTitle;
    private String categoryDescription;
    private Set<SubCategory1> subCategory1s = new HashSet<>(0);


}
