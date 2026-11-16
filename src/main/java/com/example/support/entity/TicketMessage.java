package com.example.support.entity;

import com.example.support.enums.MessageType;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
    name = "ticket_messages",
    indexes = {
        @Index(name = "idx_message_ticket", columnList = "ticket_id"),
        @Index(name = "idx_message_sender", columnList = "sender_id"),
        @Index(name = "idx_message_created", columnList = "created_at")
    }
)
public class TicketMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "message_type", nullable = false, length = 30)
    private MessageType messageType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public User getSender() { return sender; }
    public String getMessage() { return message; }
    public MessageType getMessageType() { return messageType; }
    public Instant getCreatedAt() { return createdAt; }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setSender(User sender) { this.sender = sender; }
    public void setMessage(String message) { this.message = message; }
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}