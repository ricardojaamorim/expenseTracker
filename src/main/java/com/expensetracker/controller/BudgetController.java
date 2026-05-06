package com.expensetracker.controller;

import com.expensetracker.model.Budget;
import com.expensetracker.service.BudgetService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        double remaining = service.getRemainingBudget();

        Map<String, Object> response = new HashMap<>();
        response.put("remaining", remaining);
        response.put("status", remaining < 0 ? "OVER BUDGET" : "OK");

        return response;
    }
}
