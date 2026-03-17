package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.AgentAssignment;
import com.trip.tripmanagement.service.AgentAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agentassignments")
public class AgentAssignmentController {

    private final AgentAssignmentService agentAssignmentService;

    public AgentAssignmentController(AgentAssignmentService agentAssignmentService) {
        this.agentAssignmentService = agentAssignmentService;
    }

    @PostMapping
    public AgentAssignment create(@RequestBody AgentAssignment agentAssignment) {
        return agentAssignmentService.create(agentAssignment);
    }

    @GetMapping
    public List<AgentAssignment> getAll() {
        return agentAssignmentService.getAll();
    }

    @GetMapping("/{id}")
    public AgentAssignment getById(@PathVariable Integer id) {
        return agentAssignmentService.getById(id);
    }

    @PutMapping("/{id}")
    public AgentAssignment update(@PathVariable Integer id, @RequestBody AgentAssignment updatedAssignment) {
        return agentAssignmentService.update(id, updatedAssignment);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        agentAssignmentService.delete(id);
        return "Assignment deleted successfully";
    }
}

