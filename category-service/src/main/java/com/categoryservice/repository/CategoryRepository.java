package com.categoryservice.repository;


import com.categoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


    Optional<Category> findByCategoryTitle(String categoryTitle);
}
