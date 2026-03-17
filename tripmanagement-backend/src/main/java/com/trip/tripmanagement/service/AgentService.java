package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Agent;
import com.trip.tripmanagement.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    // CREATE
    public Agent create(Agent agent) {
        return agentRepository.save(agent);
    }

    // GET ALL
    public List<Agent> getAll() {
        return agentRepository.findAll();
    }

    // GET BY ID
    public Agent getById(Integer id) {
        return agentRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Agent update(Integer id, Agent updatedAgent) {

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

    // DELETE
    public void delete(Integer id) {
        agentRepository.deleteById(id);
    }
}