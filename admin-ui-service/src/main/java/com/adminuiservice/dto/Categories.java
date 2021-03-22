package com.adminuiservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Categories {


    private String categoryTitle;

    private ParentCategory parentCategory;




}
