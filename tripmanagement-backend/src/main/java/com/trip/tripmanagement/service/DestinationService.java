package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Destination;
import com.trip.tripmanagement.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    // CREATE
    public Destination create(Destination destination) {
        return destinationRepository.save(destination);
    }

    // GET ALL
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    // GET BY ID
    public Destination getById(Integer id) {
        return destinationRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public Destination update(Integer id, Destination updatedDestination) {

        Optional<Destination> optional = destinationRepository.findById(id);

        if (optional.isPresent()) {

            Destination destination = optional.get();

            destination.setDestinationName(updatedDestination.getDestinationName());
            destination.setState(updatedDestination.getState());
            destination.setCountry(updatedDestination.getCountry());
            destination.setClimate(updatedDestination.getClimate());
            destination.setBestSeason(updatedDestination.getBestSeason());
            destination.setCrowdLevel(updatedDestination.getCrowdLevel());

            return destinationRepository.save(destination);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public Destination patch(Integer id, Destination updatedDestination) {

        Optional<Destination> optional = destinationRepository.findById(id);

        if (optional.isPresent()) {

            Destination destination = optional.get();

            if (updatedDestination.getDestinationName() != null)
                destination.setDestinationName(updatedDestination.getDestinationName());

            if (updatedDestination.getState() != null)
                destination.setState(updatedDestination.getState());

            if (updatedDestination.getCountry() != null)
                destination.setCountry(updatedDestination.getCountry());

            if (updatedDestination.getClimate() != null)
                destination.setClimate(updatedDestination.getClimate());

            if (updatedDestination.getBestSeason() != null)
                destination.setBestSeason(updatedDestination.getBestSeason());

            if (updatedDestination.getCrowdLevel() != null)
                destination.setCrowdLevel(updatedDestination.getCrowdLevel());

            return destinationRepository.save(destination);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        destinationRepository.deleteById(id);
    }
}