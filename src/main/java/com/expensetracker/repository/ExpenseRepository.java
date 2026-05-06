package com.expensetracker.repository;
import com.expensetracker.model.Expense;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
}

