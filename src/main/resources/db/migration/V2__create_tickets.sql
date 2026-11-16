CREATE TABLE tickets (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ticket_number VARCHAR(30) NOT NULL,
    subject VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,

    customer_id BIGINT NOT NULL,
    assigned_agent_id BIGINT NULL,

    category VARCHAR(40) NOT NULL DEFAULT 'OTHER',
    priority VARCHAR(20) NOT NULL DEFAULT 'MEDIUM',
    status VARCHAR(30) NOT NULL DEFAULT 'OPEN',

    ai_classified BOOLEAN NOT NULL DEFAULT FALSE,

    created_at TIMESTAMP(6) NOT NULL,
    updated_at TIMESTAMP(6) NOT NULL,
    resolved_at TIMESTAMP(6) NULL,
    closed_at TIMESTAMP(6) NULL,

    PRIMARY KEY (id),

    CONSTRAINT uk_ticket_number UNIQUE (ticket_number),

    CONSTRAINT fk_ticket_customer
        FOREIGN KEY (customer_id)
        REFERENCES users(id),

    CONSTRAINT fk_ticket_agent
        FOREIGN KEY (assigned_agent_id)
        REFERENCES users(id),

    INDEX idx_ticket_customer (customer_id),
    INDEX idx_ticket_agent (assigned_agent_id),
    INDEX idx_ticket_status (status),
    INDEX idx_ticket_priority (priority),
    INDEX idx_ticket_created (created_at),
    INDEX idx_ticket_category (category)
);