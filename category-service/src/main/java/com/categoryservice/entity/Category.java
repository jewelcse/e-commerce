package com.categoryservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_title")
    private String categoryTitle;


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<_Category> _categories = new HashSet<>();

}
