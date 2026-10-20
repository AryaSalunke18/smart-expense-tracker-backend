package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    // Custom query to find active budgets for a user
    List<Budget> findByUserId(Long userId);
}