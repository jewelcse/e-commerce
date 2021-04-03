package com.categoryservice.request;


import com.categoryservice.entity.ParentCategory;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CategoryDto implements Serializable {

    private Long id;

    private String categoryTitle;

    private Long parentCategoryId;

    private ParentCategory parentCategory;




}
