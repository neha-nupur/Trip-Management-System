package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.AgentAssignment;
import com.trip.tripmanagement.repository.AgentAssignmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agentassignments")
public class AgentAssignmentController {

    private final AgentAssignmentRepository agentAssignmentRepository;

    public AgentAssignmentController(AgentAssignmentRepository agentAssignmentRepository) {
        this.agentAssignmentRepository = agentAssignmentRepository;
    }

    @PostMapping
    public AgentAssignment create(@RequestBody AgentAssignment agentAssignment) {
        return agentAssignmentRepository.save(agentAssignment);
    }

    @GetMapping
    public List<AgentAssignment> getAll() {
        return agentAssignmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public AgentAssignment getById(@PathVariable Integer id) {
        return agentAssignmentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public AgentAssignment update(@PathVariable Integer id, @RequestBody AgentAssignment updatedAssignment) {

        Optional<AgentAssignment> optionalAssignment = agentAssignmentRepository.findById(id);

        if (optionalAssignment.isPresent()) {

            AgentAssignment assignment = optionalAssignment.get();

            assignment.setTripId(updatedAssignment.getTripId());
            assignment.setAgentId(updatedAssignment.getAgentId());
            assignment.setAssignedDate(updatedAssignment.getAssignedDate());

            return agentAssignmentRepository.save(assignment);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        agentAssignmentRepository.deleteById(id);

        return "Assignment deleted successfully";
    }
}

