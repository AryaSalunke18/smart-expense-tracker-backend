package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom query to find all expenses belonging to a specific user
    List<Expense> findByUserId(Long userId);
}