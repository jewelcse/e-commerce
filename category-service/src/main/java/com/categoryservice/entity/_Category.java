package com.categoryservice.entity;

import lombok.*;
import com.categoryservice.entity.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "_categories")
public class _Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "_category_title")
    private String _CategoryTitle;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    private Category category;

    @OneToMany(mappedBy = "_category", cascade = CascadeType.ALL)
    private Set<__Category> __categories = new HashSet<>();

}
