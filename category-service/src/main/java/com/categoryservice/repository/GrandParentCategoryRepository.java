package com.categoryservice.repository;


import com.categoryservice.entity.GrandParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandParentCategoryRepository extends JpaRepository<GrandParentCategory,Long> {
}
