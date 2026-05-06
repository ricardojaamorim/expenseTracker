package com.expensetracker.service;
import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public double getTotalExpenses() {
        List<Expense> expenses = repository.findAll();

        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        return total;
    }

    public List<Expense> getByCategory(String category) {
        return repository.findByCategory(category);
    }

    .


}

