package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Agent;
import com.trip.tripmanagement.repository.AgentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentRepository agentRepository;

    public AgentController(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @PostMapping
    public Agent create(@RequestBody Agent agent) {
        return agentRepository.save(agent);
    }

    @GetMapping
    public List<Agent> getAll() {
        return agentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Agent getById(@PathVariable Integer id) {
        return agentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Agent update(@PathVariable Integer id, @RequestBody Agent updatedAgent) {

        Optional<Agent> optionalAgent = agentRepository.findById(id);

        if (optionalAgent.isPresent()) {

            Agent agent = optionalAgent.get();

            agent.setAgentName(updatedAgent.getAgentName());
            agent.setPhone(updatedAgent.getPhone());
            agent.setEmail(updatedAgent.getEmail());
            agent.setExperienceYears(updatedAgent.getExperienceYears());
            agent.setLanguageKnown(updatedAgent.getLanguageKnown());

            return agentRepository.save(agent);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        agentRepository.deleteById(id);

        return "Agent deleted successfully";
    }
}
