package com.productservice.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubCategory2 {

    private String id;
    private String subCategory2Title;
    private Set<SubCategory3> subCategory3s = new HashSet<>(0);

}
