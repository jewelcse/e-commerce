package com.categoryservice.request;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CategoryDto implements Serializable {

    private String categoryTitle;

    private Long parentCategoryId;




}
