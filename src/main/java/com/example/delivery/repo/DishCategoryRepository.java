package com.example.delivery.repo;

import com.example.delivery.domain.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {
}
