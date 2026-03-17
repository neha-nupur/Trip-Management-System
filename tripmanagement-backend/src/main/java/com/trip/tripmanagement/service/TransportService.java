package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Transport;
import com.trip.tripmanagement.repository.TransportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    // CREATE
    public Transport create(Transport transport) {
        return transportRepository.save(transport);
    }

    // GET ALL
    public List<Transport> getAll() {
        return transportRepository.findAll();
    }

    // GET BY ID
    public Transport getById(Integer id) {
        return transportRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public Transport update(Integer id, Transport updatedTransport) {

        Optional<Transport> optional = transportRepository.findById(id);

        if (optional.isPresent()) {

            Transport transport = optional.get();

            transport.setTrip(updatedTransport.getTrip());
            transport.setTransportMode(updatedTransport.getTransportMode());
            transport.setProviderName(updatedTransport.getProviderName());
            transport.setVehicleNumber(updatedTransport.getVehicleNumber());
            transport.setDepartureTime(updatedTransport.getDepartureTime());
            transport.setArrivalTime(updatedTransport.getArrivalTime());
            transport.setCost(updatedTransport.getCost());

            return transportRepository.save(transport);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public Transport patch(Integer id, Transport updatedTransport) {

        Optional<Transport> optional = transportRepository.findById(id);

        if (optional.isPresent()) {

            Transport transport = optional.get();

            if (updatedTransport.getTrip() != null)
                transport.setTrip(updatedTransport.getTrip());

            if (updatedTransport.getTransportMode() != null)
                transport.setTransportMode(updatedTransport.getTransportMode());

            if (updatedTransport.getProviderName() != null)
                transport.setProviderName(updatedTransport.getProviderName());

            if (updatedTransport.getVehicleNumber() != null)
                transport.setVehicleNumber(updatedTransport.getVehicleNumber());

            if (updatedTransport.getDepartureTime() != null)
                transport.setDepartureTime(updatedTransport.getDepartureTime());

            if (updatedTransport.getArrivalTime() != null)
                transport.setArrivalTime(updatedTransport.getArrivalTime());

            if (updatedTransport.getCost() != null)
                transport.setCost(updatedTransport.getCost());

            return transportRepository.save(transport);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        transportRepository.deleteById(id);
    }
}