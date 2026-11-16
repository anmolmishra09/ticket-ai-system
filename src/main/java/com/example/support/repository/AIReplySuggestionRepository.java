package com.example.support.repository;

import com.example.support.entity.AIReplySuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIReplySuggestionRepository
        extends JpaRepository<AIReplySuggestion, Long> {

    List<AIReplySuggestion> findByTicketIdOrderByCreatedAtDesc(
        Long ticketId
    );

    List<AIReplySuggestion> findByAgentId(Long agentId);
}