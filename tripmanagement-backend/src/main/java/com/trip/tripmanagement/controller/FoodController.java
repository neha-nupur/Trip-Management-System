package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Food;
import com.trip.tripmanagement.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // CREATE
    @PostMapping
    public Food create(@RequestBody Food food) {
        return foodService.create(food);
    }

    // GET ALL
    @GetMapping
    public List<Food> getAll() {
        return foodService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Food getById(@PathVariable Integer id) {
        return foodService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Food update(@PathVariable Integer id, @RequestBody Food updatedFood) {
        return foodService.update(id, updatedFood);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Food patch(@PathVariable Integer id, @RequestBody Food updatedFood) {
        return foodService.patch(id, updatedFood);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        foodService.delete(id);
        return "Food deleted successfully";
    }
}