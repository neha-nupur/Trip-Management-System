package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Activity;
import com.trip.tripmanagement.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    // CREATE
    @PostMapping
    public Activity create(@RequestBody Activity activity) {
        return activityService.create(activity);    }

    // GET ALL
    @GetMapping
    public List<Activity> getAll() {
        return activityService.getAll();    }

    // GET BY ID
    @GetMapping("/{id}")
    public Activity getById(@PathVariable Integer id) {
        return activityService.getById(id);    }

    // PUT (FULL UPDATE)
    @PutMapping("/{id}")
    public Activity update(@PathVariable Integer id, @RequestBody Activity updatedActivity) {
        return activityService.update(id, updatedActivity);
    }

    // PATCH (PARTIAL UPDATE)
    @PatchMapping("/{id}")
    public Activity patch(@PathVariable Integer id, @RequestBody Activity updatedActivity) {
        return activityService.patch(id, updatedActivity);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        activityService.delete(id);
        return "Activity deleted successfully";
    }
}