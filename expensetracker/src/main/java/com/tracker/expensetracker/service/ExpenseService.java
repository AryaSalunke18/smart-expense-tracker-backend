package com.tracker.expensetracker.service;

import com.tracker.expensetracker.repository.ExpenseRepository;
import com.tracker.expensetracker.repository.UserRepository;
import com.tracker.expensetracker.repository.CategoryRepository;
import com.tracker.expensetracker.model.Category;
import com.tracker.expensetracker.model.Expense;
import com.tracker.expensetracker.model.User;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    // Explicit constructor for Spring Boot Dependency Injection
    public ExpenseService(ExpenseRepository expenseRepository, 
                          UserRepository userRepository, 
                          CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }



    //getter
    public List<Expense> getExpenseByUser(Long userId){
        return expenseRepository.findByUserId(userId);
    }
    //setter
    public Expense addExpense(Long userId,Long categoryId, Expense expenseDetails){
        User user=userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id: "+userId));

        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()->new RuntimeException("Category not found with id: "+categoryId));
                
                expenseDetails.setUser(user);
                expenseDetails.setCategory(category);

                return expenseRepository.save(expenseDetails);
    }

}
