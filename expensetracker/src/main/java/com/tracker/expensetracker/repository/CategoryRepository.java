package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // You can add custom find methods here later if needed
}