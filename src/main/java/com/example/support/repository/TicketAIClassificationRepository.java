package com.example.support.repository;

import com.example.support.entity.TicketAIClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketAIClassificationRepository
        extends JpaRepository<TicketAIClassification, Long> {

    List<TicketAIClassification> findByTicketIdOrderByCreatedAtDesc(
        Long ticketId
    );

    Optional<TicketAIClassification> findFirstByTicketIdOrderByCreatedAtDesc(
        Long ticketId
    );
}