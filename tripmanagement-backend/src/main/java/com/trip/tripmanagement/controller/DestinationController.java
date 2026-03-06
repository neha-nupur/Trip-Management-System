package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Destination;
import com.trip.tripmanagement.repository.DestinationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationRepository destinationRepository;

    public DestinationController(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    // CREATE
    @PostMapping
    public Destination create(@RequestBody Destination destination) {
        return destinationRepository.save(destination);
    }

    // GET ALL
    @GetMapping
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Destination getById(@PathVariable Integer id) {
        return destinationRepository.findById(id).orElse(null);
    }

    // PUT (FULL UPDATE)
    @PutMapping("/{id}")
    public Destination update(@PathVariable Integer id, @RequestBody Destination updatedDestination) {

        Optional<Destination> optionalDestination = destinationRepository.findById(id);

        if (optionalDestination.isPresent()) {

            Destination destination = optionalDestination.get();

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

    // PATCH
    @PatchMapping("/{id}")
    public Destination patch(@PathVariable Integer id, @RequestBody Destination updatedDestination) {

        Optional<Destination> optionalDestination = destinationRepository.findById(id);

        if (optionalDestination.isPresent()) {

            Destination destination = optionalDestination.get();

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
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        destinationRepository.deleteById(id);

        return "Destination deleted successfully";
    }
}