package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.AgentAssignment;
import com.trip.tripmanagement.repository.AgentAssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentAssignmentService {

    private final AgentAssignmentRepository agentAssignmentRepository;

    public AgentAssignmentService(AgentAssignmentRepository agentAssignmentRepository) {
        this.agentAssignmentRepository = agentAssignmentRepository;
    }

    // CREATE
    public AgentAssignment create(AgentAssignment assignment) {
        return agentAssignmentRepository.save(assignment);
    }

    // GET ALL
    public List<AgentAssignment> getAll() {
        return agentAssignmentRepository.findAll();
    }

    // GET BY ID
    public AgentAssignment getById(Integer id) {
        return agentAssignmentRepository.findById(id).orElse(null);
    }

    // UPDATE
    // PATCH
    public AgentAssignment patch(Integer id, AgentAssignment updatedAssignment) {

        Optional<AgentAssignment> optionalAssignment =
                agentAssignmentRepository.findById(id);

        if (optionalAssignment.isPresent()) {

            AgentAssignment assignment = optionalAssignment.get();

            if (updatedAssignment.getAgentId() != null)
                assignment.setAgentId(updatedAssignment.getAgentId());

            if (updatedAssignment.getTripId() != null)
                assignment.setTripId(updatedAssignment.getTripId());

            if (updatedAssignment.getAssignedDate() != null)
                assignment.setAssignedDate(updatedAssignment.getAssignedDate());

            return agentAssignmentRepository.save(assignment);
        }

        return null;
    }


    // UPDATE - PUT
    public AgentAssignment update(Integer id, AgentAssignment updatedAssignment) {

        Optional<AgentAssignment> optionalAssignment =
                agentAssignmentRepository.findById(id);

        if (optionalAssignment.isPresent()) {

            AgentAssignment assignment = optionalAssignment.get();

            assignment.setAgentId(updatedAssignment.getAgentId());
            assignment.setTripId(updatedAssignment.getTripId());
            assignment.setAssignedDate(updatedAssignment.getAssignedDate());

            return agentAssignmentRepository.save(assignment);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        agentAssignmentRepository.deleteById(id);
    }
}