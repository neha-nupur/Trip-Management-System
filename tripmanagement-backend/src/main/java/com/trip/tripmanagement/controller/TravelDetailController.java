package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.TravelDetail;
import com.trip.tripmanagement.repository.TravelDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/travel-details")
public class TravelDetailController {

    private final TravelDetailRepository travelDetailRepository;

    public TravelDetailController(TravelDetailRepository travelDetailRepository) {
        this.travelDetailRepository = travelDetailRepository;
    }

    @PostMapping
    public TravelDetail create(@RequestBody TravelDetail travelDetail) {
        return travelDetailRepository.save(travelDetail);
    }

    @GetMapping
    public List<TravelDetail> getAll() {
        return travelDetailRepository.findAll();
    }

    @GetMapping("/{id}")
    public TravelDetail getById(@PathVariable Integer id) {
        return travelDetailRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public TravelDetail update(@PathVariable Integer id, @RequestBody TravelDetail updatedTravelDetail) {

        Optional<TravelDetail> optional = travelDetailRepository.findById(id);

        if (optional.isPresent()) {

            TravelDetail travelDetail = optional.get();

            travelDetail.setTransportMode(updatedTravelDetail.getTransportMode());
            travelDetail.setSourceCity(updatedTravelDetail.getSourceCity());
            travelDetail.setTravelDurationHours(updatedTravelDetail.getTravelDurationHours());
            travelDetail.setTravelNotes(updatedTravelDetail.getTravelNotes());

            return travelDetailRepository.save(travelDetail);
        }

        return null;
    }

    @PatchMapping("/{id}")
    public TravelDetail patch(@PathVariable Integer id, @RequestBody TravelDetail updatedTravelDetail) {

        Optional<TravelDetail> optional = travelDetailRepository.findById(id);

        if (optional.isPresent()) {

            TravelDetail travelDetail = optional.get();

            if (updatedTravelDetail.getTransportMode() != null)
                travelDetail.setTransportMode(updatedTravelDetail.getTransportMode());

            if (updatedTravelDetail.getSourceCity() != null)
                travelDetail.setSourceCity(updatedTravelDetail.getSourceCity());

            if (updatedTravelDetail.getTravelDurationHours() != null)
                travelDetail.setTravelDurationHours(updatedTravelDetail.getTravelDurationHours());

            if (updatedTravelDetail.getTravelNotes() != null)
                travelDetail.setTravelNotes(updatedTravelDetail.getTravelNotes());

            return travelDetailRepository.save(travelDetail);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        travelDetailRepository.deleteById(id);

        return "Travel Detail deleted successfully";
    }
}