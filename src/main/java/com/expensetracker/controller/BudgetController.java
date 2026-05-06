package com.expensetracker.controller;

import com.expensetracker.model.Budget;
import com.expensetracker.service.BudgetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    private final BudgetService service;

    public BudgetController(BudgetService service) {
        this.service = service;
    }

    @PostMapping
    public Budget setBudget(@RequestBody Budget budget) {
        return service.setBudget(budget.getAmount());
    }

    @GetMapping("/remaining")
    public double getRemaining() {
        return service.getRemainingBudget();
    }
}
