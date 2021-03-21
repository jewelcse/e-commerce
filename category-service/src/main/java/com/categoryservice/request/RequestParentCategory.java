package com.categoryservice.request;


import com.categoryservice.entity.Category;
import com.categoryservice.entity.GrandParentCategory;
import com.categoryservice.entity.ParentCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class RequestParentCategory {


    private Category category;

    private ParentCategory parentCategory;



}
