package com.categoryservice.request;


import com.categoryservice.entity.Category;
import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.entity.ParentCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ParentCategoryDto implements Serializable {

    private String parentCategoryTitle;

    private Long grandParentCategoryId;




}
