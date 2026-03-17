package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Destination;
import com.trip.tripmanagement.service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    // CREATE
    @PostMapping
    public Destination create(@RequestBody Destination destination) {
        return destinationService.create(destination);
    }

    // GET ALL
    @GetMapping
    public List<Destination> getAll() {
        return destinationService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Destination getById(@PathVariable Integer id) {
        return destinationService.getById(id);
    }

    // PUT (FULL UPDATE)
    @PutMapping("/{id}")
    public Destination update(@PathVariable Integer id, @RequestBody Destination updatedDestination) {
        return destinationService.update(id, updatedDestination);
    }

    // PATCH (PARTIAL UPDATE)
    @PatchMapping("/{id}")
    public Destination patch(@PathVariable Integer id, @RequestBody Destination updatedDestination) {
        return destinationService.patch(id, updatedDestination);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        destinationService.delete(id);
        return "Destination deleted successfully";
    }
}