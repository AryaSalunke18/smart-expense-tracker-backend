package com.tracker.expensetracker.repository;

import com.tracker.expensetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find a user by email (useful for login/authentication)
    Optional<User> findByEmail(String email);
}