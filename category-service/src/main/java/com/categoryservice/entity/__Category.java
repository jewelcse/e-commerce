package com.categoryservice.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "__categories")
public class __Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "__category_title")
    private String __CategoryTitle;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    private _Category _category;

}
