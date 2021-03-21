package com.adminuiservice.dto;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Category {

    private Long id;

    private String categoryTitle;

    private Long parentCategoryId;

}
