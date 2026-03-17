package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.TravelDetail;
import com.trip.tripmanagement.service.TravelDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-details")
public class TravelDetailController {

    private final TravelDetailService travelDetailService;

    public TravelDetailController(TravelDetailService travelDetailService) {
        this.travelDetailService = travelDetailService;
    }

    // CREATE
    @PostMapping
    public TravelDetail create(@RequestBody TravelDetail travelDetail) {
        return travelDetailService.create(travelDetail);
    }

    // GET ALL
    @GetMapping
    public List<TravelDetail> getAll() {
        return travelDetailService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TravelDetail getById(@PathVariable Integer id) {
        return travelDetailService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public TravelDetail update(@PathVariable Integer id, @RequestBody TravelDetail updatedTravelDetail) {
        return travelDetailService.update(id, updatedTravelDetail);
    }

    // PATCH
    @PatchMapping("/{id}")
    public TravelDetail patch(@PathVariable Integer id, @RequestBody TravelDetail updatedTravelDetail) {
        return travelDetailService.patch(id, updatedTravelDetail);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        travelDetailService.delete(id);
        return "Travel Detail deleted successfully";
    }
}