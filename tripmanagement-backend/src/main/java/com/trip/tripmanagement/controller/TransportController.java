package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Transport;
import com.trip.tripmanagement.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transports")
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    // CREATE
    @PostMapping
    public Transport create(@RequestBody Transport transport) {
        return transportService.create(transport);
    }

    // GET ALL
    @GetMapping
    public List<Transport> getAll() {
        return transportService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Transport getById(@PathVariable Integer id) {
        return transportService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Transport update(@PathVariable Integer id, @RequestBody Transport updatedTransport) {
        return transportService.update(id, updatedTransport);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Transport patch(@PathVariable Integer id, @RequestBody Transport updatedTransport) {
        return transportService.patch(id, updatedTransport);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        transportService.delete(id);
        return "Transport deleted successfully";
    }
}