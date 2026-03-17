package com.trip.tripmanagement.controller;
import com.trip.tripmanagement.entity.Booking;
import com.trip.tripmanagement.service.BookingService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Integer id) {
        return bookingService.getById(id);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Integer id, @RequestBody Booking updatedBooking) {
        return bookingService.update(id, updatedBooking);
    }


    @PatchMapping("/{id}")
    public Booking patch(@PathVariable Integer id, @RequestBody Booking updatedBooking) {
        return bookingService.patch(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        bookingService.delete(id);
        return "Booking deleted";
    }
}