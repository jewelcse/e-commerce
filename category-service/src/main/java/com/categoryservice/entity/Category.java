package com.categoryservice.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_title")
    private String categoryTitle;

    @ManyToOne(optional = false)
    @JoinColumn(name = "parent_category_id", nullable = false)
    private ParentCategory parentCategory;

}
