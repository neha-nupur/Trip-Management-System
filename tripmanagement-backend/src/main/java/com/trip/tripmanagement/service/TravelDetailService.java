package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.TravelDetail;
import com.trip.tripmanagement.repository.TravelDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelDetailService {

    private final TravelDetailRepository travelDetailRepository;

    public TravelDetailService(TravelDetailRepository travelDetailRepository) {
        this.travelDetailRepository = travelDetailRepository;
    }

    // CREATE
    public TravelDetail create(TravelDetail travelDetail) {
        return travelDetailRepository.save(travelDetail);
    }

    // GET ALL
    public List<TravelDetail> getAll() {
        return travelDetailRepository.findAll();
    }

    // GET BY ID
    public TravelDetail getById(Integer id) {
        return travelDetailRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public TravelDetail update(Integer id, TravelDetail updatedTravelDetail) {

        Optional<TravelDetail> optional = travelDetailRepository.findById(id);

        if (optional.isPresent()) {

            TravelDetail travelDetail = optional.get();

            travelDetail.setTripId(updatedTravelDetail.getTripId());
            travelDetail.setTransportMode(updatedTravelDetail.getTransportMode());
            travelDetail.setSourceCity(updatedTravelDetail.getSourceCity());
            travelDetail.setTravelDurationHours(updatedTravelDetail.getTravelDurationHours());
            travelDetail.setTravelNotes(updatedTravelDetail.getTravelNotes());

            return travelDetailRepository.save(travelDetail);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public TravelDetail patch(Integer id, TravelDetail updatedTravelDetail) {

        Optional<TravelDetail> optional = travelDetailRepository.findById(id);

        if (optional.isPresent()) {

            TravelDetail travelDetail = optional.get();

            if (updatedTravelDetail.getTripId() != null)
                travelDetail.setTripId(updatedTravelDetail.getTripId());

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

    // DELETE
    public void delete(Integer id) {
        travelDetailRepository.deleteById(id);
    }
}