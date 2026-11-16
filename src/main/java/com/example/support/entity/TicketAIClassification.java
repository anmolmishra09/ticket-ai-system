package com.example.support.entity;

import com.example.support.enums.TicketCategory;
import com.example.support.enums.TicketPriority;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(
    name = "ticket_ai_classifications",
    indexes = {
        @Index(name = "idx_ai_classification_ticket", columnList = "ticket_id")
    }
)
public class TicketAIClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private TicketCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TicketPriority priority;

    @Column(length = 30)
    private String sentiment;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(name = "keywords_json", columnDefinition = "JSON")
    private String keywordsJson;

    @Column(name = "recommended_team", length = 100)
    private String recommendedTeam;

    @Column(name = "model_name", length = 100)
    private String modelName;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public TicketCategory getCategory() { return category; }
    public TicketPriority getPriority() { return priority; }
    public String getSentiment() { return sentiment; }
    public String getSummary() { return summary; }
    public String getKeywordsJson() { return keywordsJson; }
    public String getRecommendedTeam() { return recommendedTeam; }
    public String getModelName() { return modelName; }
    public Instant getCreatedAt() { return createdAt; }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setCategory(TicketCategory category) { this.category = category; }
    public void setPriority(TicketPriority priority) { this.priority = priority; }
    public void setSentiment(String sentiment) { this.sentiment = sentiment; }
    public void setSummary(String summary) { this.summary = summary; }
    public void setKeywordsJson(String keywordsJson) { this.keywordsJson = keywordsJson; }
    public void setRecommendedTeam(String recommendedTeam) { this.recommendedTeam = recommendedTeam; }
    public void setModelName(String modelName) { this.modelName = modelName; }
}