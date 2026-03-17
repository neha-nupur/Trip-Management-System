package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Hotel;
import com.trip.tripmanagement.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // CREATE
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // GET ALL
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    // GET BY ID
    public Hotel getById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public Hotel update(Integer id, Hotel updatedHotel) {

        Optional<Hotel> optional = hotelRepository.findById(id);

        if (optional.isPresent()) {

            Hotel hotel = optional.get();

            hotel.setTrip(updatedHotel.getTrip());
            hotel.setHotelName(updatedHotel.getHotelName());
            hotel.setCity(updatedHotel.getCity());
            hotel.setAddress(updatedHotel.getAddress());
            hotel.setStarRating(updatedHotel.getStarRating());
            hotel.setCostPerNight(updatedHotel.getCostPerNight());
            hotel.setTotalDays(updatedHotel.getTotalDays());
            hotel.setTotalHotelCost(updatedHotel.getTotalHotelCost());

            return hotelRepository.save(hotel);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public Hotel patch(Integer id, Hotel updatedHotel) {

        Optional<Hotel> optional = hotelRepository.findById(id);

        if (optional.isPresent()) {

            Hotel hotel = optional.get();

            if (updatedHotel.getTrip() != null)
                hotel.setTrip(updatedHotel.getTrip());

            if (updatedHotel.getHotelName() != null)
                hotel.setHotelName(updatedHotel.getHotelName());

            if (updatedHotel.getCity() != null)
                hotel.setCity(updatedHotel.getCity());

            if (updatedHotel.getAddress() != null)
                hotel.setAddress(updatedHotel.getAddress());

            if (updatedHotel.getStarRating() != null)
                hotel.setStarRating(updatedHotel.getStarRating());

            if (updatedHotel.getCostPerNight() != null)
                hotel.setCostPerNight(updatedHotel.getCostPerNight());

            if (updatedHotel.getTotalDays() != null)
                hotel.setTotalDays(updatedHotel.getTotalDays());

            if (updatedHotel.getTotalHotelCost() != null)
                hotel.setTotalHotelCost(updatedHotel.getTotalHotelCost());

            return hotelRepository.save(hotel);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        hotelRepository.deleteById(id);
    }
}