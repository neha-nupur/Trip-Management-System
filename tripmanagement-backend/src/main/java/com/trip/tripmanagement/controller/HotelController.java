package com.trip.tripmanagement.controller;
import com.trip.tripmanagement.entity.Hotel;
import com.trip.tripmanagement.repository.HotelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @GetMapping
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getById(@PathVariable Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        hotelRepository.deleteById(id);
        return "Hotel deleted";
    }
}