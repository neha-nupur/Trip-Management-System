package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Hotel;
import com.trip.tripmanagement.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // CREATE
    @PostMapping
    public Hotel create(@RequestBody Hotel hotel) {
        return hotelService.create(hotel);
    }

    // GET ALL
    @GetMapping
    public List<Hotel> getAll() {
        return hotelService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Hotel getById(@PathVariable Integer id) {
        return hotelService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Hotel update(@PathVariable Integer id, @RequestBody Hotel updatedHotel) {
        return hotelService.update(id, updatedHotel);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Hotel patch(@PathVariable Integer id, @RequestBody Hotel updatedHotel) {
        return hotelService.patch(id, updatedHotel);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        hotelService.delete(id);
        return "Hotel deleted successfully";
    }
}