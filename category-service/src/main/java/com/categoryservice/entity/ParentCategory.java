package com.categoryservice.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "parent_categories")
public class ParentCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_title")
    private String ParentCategoryTitle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grant_category_id", nullable = false)
    private GrandParentCategory grandParentCategory;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Category> categories;
}
