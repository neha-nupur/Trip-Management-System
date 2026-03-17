package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Activity;
import com.trip.tripmanagement.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // CREATE
    public Activity create(Activity activity) {
        return activityRepository.save(activity);
    }

    // GET ALL
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    // GET BY ID
    public Activity getById(Integer id) {
        return activityRepository.findById(id).orElse(null);
    }

    // UPDATE - PUT METHOD
    public Activity update(Integer id, Activity updatedActivity) {

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

    //PATCH METHOD
    public Activity patch(Integer id, Activity updatedActivity) {

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
    public void delete(Integer id) {
        activityRepository.deleteById(id);
    }
}