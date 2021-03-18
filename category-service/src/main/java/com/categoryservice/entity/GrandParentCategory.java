package com.categoryservice.entity;


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

    @OneToMany(mappedBy = "grandParentCategory", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ParentCategory> parentCategories;



}
