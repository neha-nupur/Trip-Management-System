package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Trip;
import com.trip.tripmanagement.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // CREATE
    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripService.create(trip);
    }

    // GET ALL
    @GetMapping
    public List<Trip> getAll() {
        return tripService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Trip getById(@PathVariable Integer id) {
        return tripService.getById(id);
    }

    // PUT (FULL UPDATE)
    @PutMapping("/{id}")
    public Trip update(@PathVariable Integer id, @RequestBody Trip updatedTrip) {
        return tripService.update(id, updatedTrip);
    }

    // PATCH (PARTIAL UPDATE)
    @PatchMapping("/{id}")
    public Trip patch(@PathVariable Integer id, @RequestBody Trip updatedTrip) {
        return tripService.patch(id, updatedTrip);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        tripService.delete(id);
        return "Trip deleted successfully";
    }
}