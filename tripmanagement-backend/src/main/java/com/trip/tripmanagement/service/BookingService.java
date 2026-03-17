package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Booking;
import com.trip.tripmanagement.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // CREATE
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    // GET ALL
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    // GET BY ID
    public Booking getById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    // UPDATE
    // UPDATE
    public Booking update(Integer id, Booking updatedBooking) {

        Optional<Booking> optional = bookingRepository.findById(id);

        if (optional.isPresent()) {

            Booking booking = optional.get();

            booking.setUser(updatedBooking.getUser());
            booking.setTrip(updatedBooking.getTrip());
            booking.setBookingDate(updatedBooking.getBookingDate());
            booking.setBookingStatus(updatedBooking.getBookingStatus());

            return bookingRepository.save(booking);
        }

        return null;
    }

    // PATCH
    // PATCH
    public Booking patch(Integer id, Booking updatedBooking) {

        Optional<Booking> optional = bookingRepository.findById(id);

        if (optional.isPresent()) {

            Booking booking = optional.get();

            if (updatedBooking.getUser() != null)
                booking.setUser(updatedBooking.getUser());

            if (updatedBooking.getTrip() != null)
                booking.setTrip(updatedBooking.getTrip());

            if (updatedBooking.getBookingDate() != null)
                booking.setBookingDate(updatedBooking.getBookingDate());

            if (updatedBooking.getBookingStatus() != null)
                booking.setBookingStatus(updatedBooking.getBookingStatus());

            return bookingRepository.save(booking);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        bookingRepository.deleteById(id);
    }
}