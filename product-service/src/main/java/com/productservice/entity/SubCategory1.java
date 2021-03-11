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
public class SubCategory1 {

    private String id;
    private String subCategory1Title;
    private Set<SubCategory2> subCategory2s = new HashSet<>(0);

}
