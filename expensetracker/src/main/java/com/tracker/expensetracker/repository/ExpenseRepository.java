package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Custom query to find all expenses belonging to a specific user
    List<Expense> findByUserId(Long userId);

    List<Expense> findByUserIdAndDateBetween(Long userId,LocalDate startDate,LocalDate endDate);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id=:userId")
    BigDecimal getTotalAmountByUserId(@Param("userId")Long userId);

}