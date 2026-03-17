package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Expense;
import com.trip.tripmanagement.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // CREATE
    public Expense create(Expense expense) {
        return expenseRepository.save(expense);
    }

    // GET ALL
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    // GET BY ID
    public Expense getById(Integer id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public Expense update(Integer id, Expense updatedExpense) {

        Optional<Expense> optional = expenseRepository.findById(id);

        if (optional.isPresent()) {

            Expense expense = optional.get();

            expense.setTrip(updatedExpense.getTrip());
            expense.setTransportCost(updatedExpense.getTransportCost());
            expense.setHotelCost(updatedExpense.getHotelCost());
            expense.setFoodCost(updatedExpense.getFoodCost());
            expense.setMiscellaneousCost(updatedExpense.getMiscellaneousCost());
            expense.setTotalCost(updatedExpense.getTotalCost());
            expense.setLastUpdated(updatedExpense.getLastUpdated());

            return expenseRepository.save(expense);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public Expense patch(Integer id, Expense updatedExpense) {

        Optional<Expense> optional = expenseRepository.findById(id);

        if (optional.isPresent()) {

            Expense expense = optional.get();

            if (updatedExpense.getTrip() != null)
                expense.setTrip(updatedExpense.getTrip());

            if (updatedExpense.getTransportCost() != null)
                expense.setTransportCost(updatedExpense.getTransportCost());

            if (updatedExpense.getHotelCost() != null)
                expense.setHotelCost(updatedExpense.getHotelCost());

            if (updatedExpense.getFoodCost() != null)
                expense.setFoodCost(updatedExpense.getFoodCost());

            if (updatedExpense.getMiscellaneousCost() != null)
                expense.setMiscellaneousCost(updatedExpense.getMiscellaneousCost());

            if (updatedExpense.getTotalCost() != null)
                expense.setTotalCost(updatedExpense.getTotalCost());

            if (updatedExpense.getLastUpdated() != null)
                expense.setLastUpdated(updatedExpense.getLastUpdated());

            return expenseRepository.save(expense);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        expenseRepository.deleteById(id);
    }
}