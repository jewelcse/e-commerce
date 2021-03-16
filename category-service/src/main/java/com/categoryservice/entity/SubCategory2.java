package com.categoryservice.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubCategory2 {

    private SubCategory1 subCategory;
    private String subCategory2Title;

}
