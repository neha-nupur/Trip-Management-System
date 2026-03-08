package com.trip.tripmanagement.repository;

import com.trip.tripmanagement.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
