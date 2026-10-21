package com.tracker.expensetracker.service;

import com.tracker.expensetracker.model.User;
import com.tracker.expensetracker.model.Category;
import com.tracker.expensetracker.model.Budget;
import com.tracker.expensetracker.repository.BudgetRepository;
import com.tracker.expensetracker.repository.CategoryRepository;
import com.tracker.expensetracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public BudgetService(BudgetRepository budgetRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.budgetRepository=budgetRepository;
        this.userRepository=userRepository;
        this.categoryRepository=categoryRepository;
    }
    public Budget createBudget(Long userId,Long categoryId,Budget budgetDetails){
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with Id: "+userId));

                Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()-> new RuntimeException("Category not found with Id: "+categoryId));

                budgetDetails.setUser(user);
                budgetDetails.setCategory(category);

                return budgetRepository.save(budgetDetails);
    }

    public List<Budget> getBudgetByUser(Long userId){
        return budgetRepository.findByUserId(userId);
    }

}
