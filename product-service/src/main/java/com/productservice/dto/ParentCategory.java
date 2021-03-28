package com.productservice.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ParentCategory {


    private Long id;

    private String parentCategoryTitle;

    private GrandParentCategory grandParentCategory;


}
