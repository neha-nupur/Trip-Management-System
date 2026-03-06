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

        Optional<Expense> optional = expenseRepository.findById(id);

        if(optional.isPresent()) {

            Expense expense = optional.get();

            expense.setTransportCost(updatedExpense.getTransportCost());
            expense.setHotelCost(updatedExpense.getHotelCost());
            expense.setFoodCost(updatedExpense.getFoodCost());
            expense.setMiscellaneousCost(updatedExpense.getMiscellaneousCost());
            expense.setTotalCost(updatedExpense.getTotalCost());

            return expenseRepository.save(expense);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        expenseRepository.deleteById(id);
        return "Expense deleted";
    }
}