package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Expense;
import com.trip.tripmanagement.repository.ExpenseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // CREATE
    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    // GET ALL
    @GetMapping
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Expense getById(@PathVariable Integer id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Expense update(@PathVariable Integer id, @RequestBody Expense updatedExpense) {
        return expenseService.update(id, updatedExpense);
    }

    @PatchMapping("/{id}")
    public Expense patch(@PathVariable Integer id, @RequestBody Expense updatedExpense) {
        return expenseService.patch(id, updatedExpense);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        expenseRepository.deleteById(id);
        return "Expense deleted";
    }
}