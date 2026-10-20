package com.tracker.expensetracker.controller;

import com.tracker.expensetracker.model.Expense;
import com.tracker.expensetracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService=expenseService;
    }

    //GET endpoint
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpenseByuser(@PathVariable Long userId){
        List<Expense> expenses=expenseService.getExpenseByUser(userId);
        return ResponseEntity.ok(expenses);

    } 

    //POST endpoint
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestParam Long userId,@RequestParam Long categoryId,@RequestBody Expense expense){
        Expense savedExpense=expenseService.addExpense(userId,categoryId,expense);
        return ResponseEntity.ok(savedExpense);
    }
 

}
