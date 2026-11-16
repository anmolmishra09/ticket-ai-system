CREATE TABLE ticket_attachments (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ticket_id BIGINT NOT NULL,
    message_id BIGINT NULL,
    uploaded_by BIGINT NOT NULL,

    original_filename VARCHAR(255) NOT NULL,
    stored_filename VARCHAR(255) NOT NULL,
    content_type VARCHAR(120) NOT NULL,
    file_size BIGINT NOT NULL,
    storage_path VARCHAR(500) NOT NULL,

    created_at TIMESTAMP(6) NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT uk_attachment_stored_filename
        UNIQUE (stored_filename),

    CONSTRAINT fk_attachment_ticket
        FOREIGN KEY (ticket_id)
        REFERENCES tickets(id),

    CONSTRAINT fk_attachment_message
        FOREIGN KEY (message_id)
        REFERENCES ticket_messages(id),

    CONSTRAINT fk_attachment_user
        FOREIGN KEY (uploaded_by)
        REFERENCES users(id),

    CONSTRAINT chk_attachment_size
        CHECK (file_size > 0),

    INDEX idx_attachment_ticket (ticket_id),
    INDEX idx_attachment_message (message_id)
);