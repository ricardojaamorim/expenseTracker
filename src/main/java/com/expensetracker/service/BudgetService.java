package com.expensetracker.service;

import com.expensetracker.model.Budget;
import com.expensetracker.repository.BudgetRepository;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {

    private final BudgetRepository repository;
    private final ExpenseService expenseService;

    public BudgetService(BudgetRepository repository, ExpenseService expenseService) {
        this.repository = repository;
        this.expenseService = expenseService;
    }

    public Budget setBudget(double amount) {
        Budget budget;

        if (repository.findAll().isEmpty()) {
            budget = new Budget();
        } else {
            budget = repository.findAll().get(0);
        }

        budget.setAmount(amount);
        return repository.save(budget);
    }

    public double getRemainingBudget() {
        if (repository.findAll().isEmpty()) return 0;

        double budgetAmount = repository.findAll().get(0).getAmount();
        double totalExpenses = expenseService.getTotalExpenses();

        return budgetAmount - totalExpenses;
    }
}