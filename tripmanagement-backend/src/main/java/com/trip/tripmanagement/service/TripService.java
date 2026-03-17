package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Trip;
import com.trip.tripmanagement.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // CREATE
    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }

    // GET ALL
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    // GET BY ID
    public Trip getById(Integer id) {
        return tripRepository.findById(id).orElse(null);
    }

    // PUT - UPDATE
    public Trip update(Integer id, Trip updatedTrip) {

        Optional<Trip> optionalTrip = tripRepository.findById(id);

        if (optionalTrip.isPresent()) {

            Trip trip = optionalTrip.get();

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

    //PATCH - UPDATE
    public Trip patch(Integer id, Trip updatedTrip) {

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
    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }
}