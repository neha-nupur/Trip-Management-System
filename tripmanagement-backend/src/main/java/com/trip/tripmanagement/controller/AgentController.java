package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Agent;
import com.trip.tripmanagement.service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping
    public Agent create(@RequestBody Agent agent) {
        return agentService.create(agent);
    }

    @GetMapping
    public List<Agent> getAll() {
        return agentService.getAll();
    }

    @GetMapping("/{id}")
    public Agent getById(@PathVariable Integer id) {
        return agentService.getById(id);
    }

    @PutMapping("/{id}")
    public Agent update(@PathVariable Integer id, @RequestBody Agent updatedAgent) {
        return agentService.update(id, updatedAgent);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        agentService.delete(id);

        return "Agent deleted successfully";
    }
}
