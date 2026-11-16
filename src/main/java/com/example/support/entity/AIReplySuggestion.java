package com.example.support.entity;

import com.example.support.enums.SuggestionStatus;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
    name = "ai_reply_suggestions",
    indexes = {
        @Index(name = "idx_ai_reply_ticket", columnList = "ticket_id"),
        @Index(name = "idx_ai_reply_agent", columnList = "agent_id")
    }
)
public class AIReplySuggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agent_id", nullable = false)
    private User agent;

    @Column(name = "generated_reply", nullable = false, columnDefinition = "TEXT")
    private String generatedReply;

    @Column(name = "model_name", length = 100)
    private String modelName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SuggestionStatus status = SuggestionStatus.GENERATED;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public User getAgent() { return agent; }
    public String getGeneratedReply() { return generatedReply; }
    public String getModelName() { return modelName; }
    public SuggestionStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setAgent(User agent) { this.agent = agent; }
    public void setGeneratedReply(String generatedReply) { this.generatedReply = generatedReply; }
    public void setModelName(String modelName) { this.modelName = modelName; }
    public void setStatus(SuggestionStatus status) { this.status = status; }
}