CREATE TABLE ticket_ai_classifications (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ticket_id BIGINT NOT NULL,

    category VARCHAR(40) NOT NULL,
    priority VARCHAR(20) NOT NULL,
    sentiment VARCHAR(30),
    summary TEXT,
    keywords_json JSON,
    recommended_team VARCHAR(100),
    model_name VARCHAR(100),

    created_at TIMESTAMP(6) NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_ai_classification_ticket
        FOREIGN KEY (ticket_id)
        REFERENCES tickets(id),

    INDEX idx_ai_classification_ticket (ticket_id),
    INDEX idx_ai_classification_created (created_at)
);

CREATE TABLE ai_reply_suggestions (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ticket_id BIGINT NOT NULL,
    agent_id BIGINT NOT NULL,

    generated_reply TEXT NOT NULL,
    model_name VARCHAR(100),
    status VARCHAR(20) NOT NULL DEFAULT 'GENERATED',

    created_at TIMESTAMP(6) NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_ai_reply_ticket
        FOREIGN KEY (ticket_id)
        REFERENCES tickets(id),

    CONSTRAINT fk_ai_reply_agent
        FOREIGN KEY (agent_id)
        REFERENCES users(id),

    INDEX idx_ai_reply_ticket (ticket_id),
    INDEX idx_ai_reply_agent (agent_id)
);