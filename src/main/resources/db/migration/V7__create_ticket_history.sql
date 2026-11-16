CREATE TABLE ticket_history (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ticket_id BIGINT NOT NULL,
    changed_by BIGINT NULL,

    action VARCHAR(100) NOT NULL,
    old_value TEXT,
    new_value TEXT,

    created_at TIMESTAMP(6) NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_history_ticket
        FOREIGN KEY (ticket_id)
        REFERENCES tickets(id),

    CONSTRAINT fk_history_user
        FOREIGN KEY (changed_by)
        REFERENCES users(id),

    INDEX idx_history_ticket (ticket_id),
    INDEX idx_history_user (changed_by),
    INDEX idx_history_created (created_at)
);