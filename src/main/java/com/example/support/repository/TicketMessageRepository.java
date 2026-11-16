package com.example.support.repository;

import com.example.support.entity.TicketMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketMessageRepository
        extends JpaRepository<TicketMessage, Long> {

    Page<TicketMessage> findByTicketIdOrderByCreatedAtAsc(
        Long ticketId,
        Pageable pageable
    );
}