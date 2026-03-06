package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.User;
import com.trip.tripmanagement.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        userRepository.deleteById(id);

        return "User deleted";
    }
}