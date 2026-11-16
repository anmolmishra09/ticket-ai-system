package com.example.support.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ticket_attachments")
public class TicketAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "message_id")
    private TicketMessage message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uploaded_by", nullable = false)
    private User uploadedBy;

    @Column(name = "original_filename", nullable = false)
    private String originalFilename;

    @Column(name = "stored_filename", nullable = false, unique = true)
    private String storedFilename;

    @Column(name = "content_type", nullable = false, length = 120)
    private String contentType;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "storage_path", nullable = false, length = 500)
    private String storagePath;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public TicketMessage getMessage() { return message; }
    public User getUploadedBy() { return uploadedBy; }
    public String getOriginalFilename() { return originalFilename; }
    public String getStoredFilename() { return storedFilename; }
    public String getContentType() { return contentType; }
    public Long getFileSize() { return fileSize; }
    public String getStoragePath() { return storagePath; }
    public Instant getCreatedAt() { return createdAt; }

    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setMessage(TicketMessage message) { this.message = message; }
    public void setUploadedBy(User uploadedBy) { this.uploadedBy = uploadedBy; }
    public void setOriginalFilename(String value) { this.originalFilename = value; }
    public void setStoredFilename(String value) { this.storedFilename = value; }
    public void setContentType(String value) { this.contentType = value; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }
    public void setStoragePath(String value) { this.storagePath = value; }
}