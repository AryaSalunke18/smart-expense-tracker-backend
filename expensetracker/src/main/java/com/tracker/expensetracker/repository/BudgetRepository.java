package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    // Custom query to find active budgets for a user
    List<Budget> findByUserId(Long userId);
}