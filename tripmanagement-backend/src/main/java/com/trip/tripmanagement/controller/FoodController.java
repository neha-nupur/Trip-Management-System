package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Food;
import com.trip.tripmanagement.repository.FoodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @PostMapping
    public Food create(@RequestBody Food food) {
        return foodRepository.save(food);
    }

    @GetMapping
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Food getById(@PathVariable Integer id) {
        return foodRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        foodRepository.deleteById(id);
        return "Food deleted";
    }
}