package com.categoryservice.repository;


import com.categoryservice.entity.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory,Long> {

    List<ParentCategory> findParentCategoriesByAndGrandParentCategory_Id(Long id);
}
