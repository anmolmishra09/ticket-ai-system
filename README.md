# AI-Powered Support Ticket Management System

Java 17 · Spring Boot 3.3 · Spring Security + JWT · MySQL 8 · Flyway · Gemini API · Docker

> Status: **Phase 1 – Project initialization.** The full README is completed in Phase 11.

## Run locally (without Docker for the app)

```bash
cp .env.example .env              # then edit values
docker compose up -d mysql        # MySQL on localhost:3307
export DB_HOST=localhost DB_PORT=3307 DB_NAME=support_ticket_db \
       DB_USERNAME=support_user DB_PASSWORD=change_me
mvn spring-boot:run               # dev profile is the default
```

## Run everything with Docker

```bash
cp .env.example .env              # set DB_PASSWORD, DB_ROOT_PASSWORD, JWT_SECRET
docker compose up --build
curl http://localhost:8080/actuator/health
```

Swagger UI: http://localhost:8080/swagger-ui/index.html

## Tests

```bash
mvn test        # ApplicationStartupIT needs a running Docker daemon (Testcontainers)
```
