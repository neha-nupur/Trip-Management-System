package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Transport;
import com.trip.tripmanagement.repository.TransportRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/transports")
public class TransportController {

    private final TransportRepository transportRepository;

    public TransportController(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @PostMapping
    public Transport create(@RequestBody Transport transport) {
        return transportRepository.save(transport);
    }

    @GetMapping
    public List<Transport> getAll() {
        return transportRepository.findAll();
    }

    @GetMapping("/{id}")
    public Transport getById(@PathVariable Integer id) {
        return transportRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        transportRepository.deleteById(id);
        return "Transport deleted";
    }
}