package com.categoryservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "grand_parent_categories")

public class GrandParentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_title")
    private String GrandParentCategoryTitle;


    @JsonIgnore
    @OneToMany(mappedBy = "grandParentCategory",
            cascade = CascadeType.ALL)
    private List<ParentCategory> parentCategories;



}
