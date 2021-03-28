package com.adminuiservice.dto;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor


public class Category {

    private Long id;

    private String categoryTitle;

    private Long parentCategoryId;

    private ParentCategory parentCategory;

}
