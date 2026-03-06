package com.trip.tripmanagement.controller;
import com.trip.tripmanagement.entity.Booking;
import com.trip.tripmanagement.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Booking update(@PathVariable Integer id, @RequestBody Booking updatedBooking) {

        Optional<Booking> optional = bookingRepository.findById(id);

        if (optional.isPresent()) {

            Booking booking = optional.get();

            booking.setBookingStatus(updatedBooking.getBookingStatus());

            return bookingRepository.save(booking);
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Booking patch(@PathVariable Integer id, @RequestBody Booking updatedBooking) {

        Optional<Booking> optional = bookingRepository.findById(id);

        if(optional.isPresent()) {

            Booking booking = optional.get();

            if(updatedBooking.getBookingStatus() != null)
                booking.setBookingStatus(updatedBooking.getBookingStatus());

            if(updatedBooking.getBookingDate() != null)
                booking.setBookingDate(updatedBooking.getBookingDate());

            if(updatedBooking.getUser() != null)
                booking.setUser(updatedBooking.getUser());

            return bookingRepository.save(booking);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        bookingRepository.deleteById(id);

        return "Booking deleted";
    }
}