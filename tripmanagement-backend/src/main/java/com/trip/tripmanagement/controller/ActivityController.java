package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Activity;
import com.trip.tripmanagement.repository.ActivityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // CREATE
    @PostMapping
    public Activity create(@RequestBody Activity activity) {
        return activityRepository.save(activity);
    }

    // GET ALL
    @GetMapping
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Activity getById(@PathVariable Integer id) {
        return activityRepository.findById(id).orElse(null);
    }

    // PUT (FULL UPDATE)
    @PutMapping("/{id}")
    public Activity update(@PathVariable Integer id, @RequestBody Activity updatedActivity) {

        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if (optionalActivity.isPresent()) {

            Activity activity = optionalActivity.get();

            activity.setActivityName(updatedActivity.getActivityName());
            activity.setLocation(updatedActivity.getLocation());
            activity.setActivityDate(updatedActivity.getActivityDate());
            activity.setDurationHours(updatedActivity.getDurationHours());
            activity.setCosts(updatedActivity.getCosts());
            activity.setBookingStatus(updatedActivity.getBookingStatus());
            activity.setBookingReference(updatedActivity.getBookingReference());
            activity.setNotes(updatedActivity.getNotes());

            return activityRepository.save(activity);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    @PatchMapping("/{id}")
    public Activity patch(@PathVariable Integer id, @RequestBody Activity updatedActivity) {

        Optional<Activity> optionalActivity = activityRepository.findById(id);

        if (optionalActivity.isPresent()) {

            Activity activity = optionalActivity.get();

            if (updatedActivity.getActivityName() != null)
                activity.setActivityName(updatedActivity.getActivityName());

            if (updatedActivity.getLocation() != null)
                activity.setLocation(updatedActivity.getLocation());

            if (updatedActivity.getActivityDate() != null)
                activity.setActivityDate(updatedActivity.getActivityDate());

            if (updatedActivity.getDurationHours() != null)
                activity.setDurationHours(updatedActivity.getDurationHours());

            if (updatedActivity.getCosts() != null)
                activity.setCosts(updatedActivity.getCosts());

            if (updatedActivity.getBookingStatus() != null)
                activity.setBookingStatus(updatedActivity.getBookingStatus());

            if (updatedActivity.getBookingReference() != null)
                activity.setBookingReference(updatedActivity.getBookingReference());

            if (updatedActivity.getNotes() != null)
                activity.setNotes(updatedActivity.getNotes());

            return activityRepository.save(activity);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        activityRepository.deleteById(id);

        return "Activity deleted successfully";
    }
}