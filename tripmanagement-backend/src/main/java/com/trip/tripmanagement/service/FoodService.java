package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Food;
import com.trip.tripmanagement.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // CREATE
    public Food create(Food food) {
        return foodRepository.save(food);
    }

    // GET ALL
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    // GET BY ID
    public Food getById(Integer id) {
        return foodRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public Food update(Integer id, Food updatedFood) {

        Optional<Food> optional = foodRepository.findById(id);

        if (optional.isPresent()) {

            Food food = optional.get();

            food.setTrip(updatedFood.getTrip());
            food.setFoodType(updatedFood.getFoodType());
            food.setRestaurantName(updatedFood.getRestaurantName());
            food.setMealDate(updatedFood.getMealDate());
            food.setCuisineType(updatedFood.getCuisineType());
            food.setCost(updatedFood.getCost());

            return foodRepository.save(food);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public Food patch(Integer id, Food updatedFood) {

        Optional<Food> optional = foodRepository.findById(id);

        if (optional.isPresent()) {

            Food food = optional.get();

            if (updatedFood.getTrip() != null)
                food.setTrip(updatedFood.getTrip());

            if (updatedFood.getFoodType() != null)
                food.setFoodType(updatedFood.getFoodType());

            if (updatedFood.getRestaurantName() != null)
                food.setRestaurantName(updatedFood.getRestaurantName());

            if (updatedFood.getMealDate() != null)
                food.setMealDate(updatedFood.getMealDate());

            if (updatedFood.getCuisineType() != null)
                food.setCuisineType(updatedFood.getCuisineType());

            if (updatedFood.getCost() != null)
                food.setCost(updatedFood.getCost());

            return foodRepository.save(food);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        foodRepository.deleteById(id);
    }
}