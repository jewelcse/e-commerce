package com.productservice.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Category {

    private Long id;

    private String categoryTitle;

    private ParentCategory parentCategory;

}
