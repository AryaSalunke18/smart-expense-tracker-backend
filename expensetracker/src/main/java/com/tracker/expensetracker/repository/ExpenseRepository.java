package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom query to find all expenses belonging to a specific user
    List<Expense> findByUserId(Long userId);
}