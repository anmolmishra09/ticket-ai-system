package com.example.support.repository;

import com.example.support.entity.Ticket;
import com.example.support.enums.TicketStatus;
import com.example.support.enums.TicketPriority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository
        extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTicketNumber(String ticketNumber);

    Page<Ticket> findByCustomerId(Long customerId, Pageable pageable);

    Page<Ticket> findByAssignedAgentId(Long agentId, Pageable pageable);

    Page<Ticket> findByStatus(TicketStatus status, Pageable pageable);

    Page<Ticket> findByPriority(TicketPriority priority, Pageable pageable);

    long countByStatus(TicketStatus status);

    long countByAssignedAgentIdAndStatus(
        Long agentId,
        TicketStatus status
    );

    boolean existsByTicketNumber(String ticketNumber);
}