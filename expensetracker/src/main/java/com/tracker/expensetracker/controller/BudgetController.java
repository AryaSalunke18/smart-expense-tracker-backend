package com.tracker.expensetracker.controller;

import com.tracker.expensetracker.model.Budget;
import com.tracker.expensetracker.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping ("/api/budgets")
public class BudgetController {
    private final BudgetService budgetService;

    BudgetController(BudgetService budgetService){
        this.budgetService=budgetService;
    }

    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Budget>> getBudgetByUser(@PathVariable Long userId){
        List<Budget> budgets=budgetService.getBudgetByUser(userId);
        return ResponseEntity.ok(budgets);

    }
    
    @PostMapping
    public ResponseEntity<Budget> createBudget(
            @RequestParam Long userId,
            @RequestParam Long categoryId,
            @RequestBody Budget budget) {
        Budget createdBudget = budgetService.createBudget(userId, categoryId, budget);
        return ResponseEntity.ok(createdBudget);
    }

}
