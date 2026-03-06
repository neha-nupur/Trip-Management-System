package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Trip;
import com.trip.tripmanagement.repository.TripRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripRepository tripRepository;

    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // CREATE
    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }

    // GET ALL
    @GetMapping
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Trip getById(@PathVariable Integer id) {
        return tripRepository.findById(id).orElse(null);
    }

    // PUT (FULL UPDATE)
    @PutMapping("/{id}")
    public Trip update(@PathVariable Integer id, @RequestBody Trip updatedTrip) {

        Optional<Trip> optional = tripRepository.findById(id);

        if (optional.isPresent()) {

            Trip trip = optional.get();

            trip.setTripTitle(updatedTrip.getTripTitle());
            trip.setDestination(updatedTrip.getDestination());
            trip.setTripType(updatedTrip.getTripType());
            trip.setPurposeOfTravel(updatedTrip.getPurposeOfTravel());
            trip.setSuitableAgeGroup(updatedTrip.getSuitableAgeGroup());
            trip.setSeason(updatedTrip.getSeason());
            trip.setPaceLevel(updatedTrip.getPaceLevel());
            trip.setRiskLevel(updatedTrip.getRiskLevel());
            trip.setStartDate(updatedTrip.getStartDate());
            trip.setEndDate(updatedTrip.getEndDate());
            trip.setMaxCapacity(updatedTrip.getMaxCapacity());

            return tripRepository.save(trip);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    @PatchMapping("/{id}")
    public Trip patch(@PathVariable Integer id, @RequestBody Trip updatedTrip) {

        Optional<Trip> optional = tripRepository.findById(id);

        if (optional.isPresent()) {

            Trip trip = optional.get();

            if (updatedTrip.getTripTitle() != null)
                trip.setTripTitle(updatedTrip.getTripTitle());

            if (updatedTrip.getDestination() != null)
                trip.setDestination(updatedTrip.getDestination());

            if (updatedTrip.getTripType() != null)
                trip.setTripType(updatedTrip.getTripType());

            if (updatedTrip.getPurposeOfTravel() != null)
                trip.setPurposeOfTravel(updatedTrip.getPurposeOfTravel());

            if (updatedTrip.getSuitableAgeGroup() != null)
                trip.setSuitableAgeGroup(updatedTrip.getSuitableAgeGroup());

            if (updatedTrip.getSeason() != null)
                trip.setSeason(updatedTrip.getSeason());

            if (updatedTrip.getPaceLevel() != null)
                trip.setPaceLevel(updatedTrip.getPaceLevel());

            if (updatedTrip.getRiskLevel() != null)
                trip.setRiskLevel(updatedTrip.getRiskLevel());

            if (updatedTrip.getStartDate() != null)
                trip.setStartDate(updatedTrip.getStartDate());

            if (updatedTrip.getEndDate() != null)
                trip.setEndDate(updatedTrip.getEndDate());

            if (updatedTrip.getMaxCapacity() != null)
                trip.setMaxCapacity(updatedTrip.getMaxCapacity());

            return tripRepository.save(trip);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        tripRepository.deleteById(id);

        return "Trip deleted successfully";
    }
}