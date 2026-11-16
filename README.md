AI-Powered Support Ticket Management System

An intelligent, secure, scalable, and AI-powered customer support ticket management backend built using Java 25, Spring Boot 3.3.5, Spring Security, JWT, MySQL, Flyway, and Google Gemini AI.

The system provides a complete backend solution for managing customer support operations, including user authentication, ticket creation, ticket assignment, priority management, status tracking, AI-powered ticket assistance, and role-based access control.

<badge color="success">Completed Project</badge>

Project Status: Completed – All Core Features Implemented

🚀 Project Overview

The AI-Powered Support Ticket Management System is a centralized platform designed to simplify and automate customer support operations.

It enables customers to raise support tickets, track their progress, and receive intelligent assistance, while administrators and support agents can efficiently manage, assign, prioritize, and resolve tickets.

The application follows a layered architecture and provides secure RESTful APIs for frontend applications and external integrations.

Key Features
Secure user registration and login.
JWT-based authentication and authorization.
Role-based access control (RBAC).
Customer, Agent, and Admin role management.
Complete support ticket CRUD operations.
Ticket assignment to support agents.
Ticket status and priority management.
Ticket category management.
Ticket tracking and filtering.
AI-powered ticket classification using Google Gemini.
AI-generated response suggestions.
AI-powered ticket summarization.
Intelligent support assistance.
MySQL database integration.
Database schema versioning using Flyway.
RESTful API architecture.
Swagger/OpenAPI documentation.
Centralized exception handling.
Input validation and secure password encryption.
Unit and integration testing.
Docker and Docker Compose deployment support.
🛠️ Technology Stack
Technology	Purpose
Java 25	Programming language
Spring Boot 3.3.5	Backend framework
Spring Security	Application security
JWT	Authentication and authorization
Spring Data JPA	Database operations
Hibernate	ORM
MySQL 8	Relational database
Flyway	Database migrations
Maven	Build and dependency management
Google Gemini API	AI-powered assistance
Docker	Containerization
Docker Compose	Multi-container deployment
Swagger/OpenAPI	API documentation
JUnit 5	Unit testing
Mockito	Mock-based testing
Testcontainers	Integration testing
📁 Project Structure
text
ticket-ai-system/
│
├── docker/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ticketaisystem/
│   │   │           ├── config/
│   │   │           ├── controller/
│   │   │           ├── dto/
│   │   │           ├── entity/
│   │   │           ├── enums/
│   │   │           ├── exception/
│   │   │           ├── repository/
│   │   │           ├── security/
│   │   │           ├── service/
│   │   │           ├── ai/
│   │   │           └── TicketAiSystemApplication.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │
│   └── test/
│       └── java/
│
├── .dockerignore
├── .env.example
├── .gitignore
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md

⚙️ Installation and Setup
Prerequisites

Make sure the following software is installed:

Java 25 (or the configured Java version).
Apache Maven.
MySQL 8.
Git.
Docker Desktop (optional).

Verify your installations:

bash
java -version
mvn -version
git --version

1. Clone the Repository
bash
git clone https://github.com/anmolmishra09/ticket-ai-system.git


Navigate into the project directory:

bash
cd ticket-ai-system

2. Configure MySQL

Make sure MySQL Server 8 is installed and running.

Create the database:

sql
CREATE DATABASE support_ticket_db;


Create a dedicated database user:

sql
CREATE USER 'support_user'@'localhost'
IDENTIFIED BY 'your_secure_password';

GRANT ALL PRIVILEGES ON support_ticket_db.*
TO 'support_user'@'localhost';

FLUSH PRIVILEGES;

3. Configure Environment Variables

Configure the following environment variables before starting the application.

Windows PowerShell:

powershell
$env:DB_HOST = "localhost"
$env:DB_PORT = "3306"
$env:DB_NAME = "support_ticket_db"
$env:DB_USERNAME = "support_user"
$env:DB_PASSWORD = "your_secure_password"

$env:JWT_SECRET = "your-secure-jwt-secret-of-at-least-32-bytes"

$env:GEMINI_API_KEY = "your-gemini-api-key"


Linux / macOS:

bash
export DB_HOST=localhost
export DB_PORT=3306
export DB_NAME=support_ticket_db
export DB_USERNAME=support_user
export DB_PASSWORD=your_secure_password

export JWT_SECRET=your-secure-jwt-secret-of-at-least-32-bytes

export GEMINI_API_KEY=your-gemini-api-key


Ensure environment variable names match the placeholders configured in the application.

4. Build the Project
bash
mvn clean install

5. Run the Application
bash
mvn spring-boot:run


Application URL:

text
http://localhost:8080

🔐 Authentication and Security

The application implements secure authentication and authorization using Spring Security and JWT.

Authentication Features
User registration.
User login.
Password encryption using BCrypt.
JWT access token generation.
JWT token validation.
Stateless authentication.
Protected REST endpoints.
Role-based endpoint authorization.
Secure access to ticket management operations.
Supported User Roles
Role	Permissions
ADMIN	Manage users, agents, and all tickets
AGENT	View assigned tickets and manage ticket resolution
CUSTOMER	Create tickets and track their own tickets
Authentication Flow
text
       Client
          |
          v
    Login Request
          |
          v
  Spring Security
          |
          v
 Credential Validation
          |
          v
   JWT Generation
          |
          v
  JWT Authentication
          |
          v
 Role-Based Authorization
          |
          v
 Access Protected APIs

🎫 Support Ticket Management

The system provides complete ticket lifecycle management.

Ticket Features
Create new support tickets.
Retrieve ticket details.
Update ticket information.
Delete tickets according to authorization rules.
Assign tickets to support agents.
Change ticket status.
Update ticket priority.
Categorize tickets.
Track ticket history.
Filter tickets based on status, priority, and category.
Ticket Status
OPEN
IN_PROGRESS
PENDING
RESOLVED
CLOSED
Ticket Priority
LOW
MEDIUM
HIGH
CRITICAL
Ticket Lifecycle
text
     Ticket Created
           |
           v
          OPEN
           |
           v
       IN_PROGRESS
           |
           v
         PENDING
           |
           v
        RESOLVED
           |
           v
         CLOSED

🤖 AI Integration – Google Gemini

The application integrates Google Gemini AI to provide intelligent assistance for customer support operations.

AI-Powered Features

1. Automatic Ticket Classification

Analyzes ticket descriptions and suggests relevant categories and priorities.

2. Intelligent Response Suggestions

Generates contextual response suggestions to help support agents respond to customers efficiently.

3. Ticket Summarization

Converts lengthy ticket descriptions and conversations into concise summaries.

4. AI Support Assistance

Provides intelligent assistance for understanding and handling customer support queries.

5. Smart Ticket Analysis

Analyzes ticket content and helps agents understand customer issues more efficiently.

AI-generated results are treated as suggestions and can be reviewed by support agents before being sent to customers.

🗄️ Database Management

The application uses MySQL 8 as its primary relational database.

Spring Data JPA and Hibernate handle database operations, while Flyway manages database schema versioning.

Database Features
User information management.
Role management.
Support ticket management.
Ticket assignment relationships.
Ticket status and priority tracking.
Database constraints and relationships.
Automatic schema migrations.

Migration files:

text
src/main/resources/db/migration/


Flyway automatically validates and applies pending migrations during application startup.

🌐 REST API Endpoints

The application exposes RESTful APIs for authentication, user management, ticket operations, and AI assistance.

Authentication APIs
Method	Endpoint	Description
POST	/api/auth/register	Register a new user
POST	/api/auth/login	Authenticate user
GET	/api/auth/me	Get authenticated user details
User Management APIs
Method	Endpoint	Description
GET	/api/users	Retrieve users
GET	/api/users/{id}	Get user by ID
PUT	/api/users/{id}	Update user
DELETE	/api/users/{id}	Delete user
Ticket Management APIs
Method	Endpoint	Description
POST	/api/tickets	Create a support ticket
GET	/api/tickets	Retrieve tickets
GET	/api/tickets/{id}	Get ticket details
PUT	/api/tickets/{id}	Update ticket
DELETE	/api/tickets/{id}	Delete ticket
PATCH	/api/tickets/{id}/status	Update ticket status
PATCH	/api/tickets/{id}/priority	Update ticket priority
PATCH	/api/tickets/{id}/assign	Assign ticket to agent
AI Assistance APIs
Method	Endpoint	Description
POST	/api/ai/classify/{ticketId}	Classify a ticket
POST	/api/ai/suggest-response/{ticketId}	Generate response suggestions
POST	/api/ai/summarize/{ticketId}	Generate ticket summary
📖 API Documentation

The application uses Swagger/OpenAPI for interactive API documentation.

After starting the application, access:

Swagger UI

text
http://localhost:8080/swagger-ui/index.html


OpenAPI JSON

text
http://localhost:8080/v3/api-docs


Swagger allows developers to explore API endpoints, understand request and response structures, and test REST APIs.

🐳 Docker Deployment

The application supports containerized deployment using Docker and Docker Compose.

1. Configure Environment Variables
bash
cp .env.example .env


Update the .env file with database credentials, JWT secret, and Gemini API key.

2. Start the Application
bash
docker compose up --build -d

3. Verify Application Health
text
http://localhost:8080/actuator/health


Expected response:

json
{
  "status": "UP"
}

4. View Container Logs
bash
docker compose logs -f

5. Stop Containers
bash
docker compose down


To remove containers and associated database volumes:

bash
docker compose down -v

🧪 Testing and Quality Assurance

The project includes unit testing and integration testing to validate application functionality.

Testing Coverage Areas
Authentication and authorization.
User registration and login.
JWT token validation.
Ticket creation and retrieval.
Ticket status and priority updates.
Ticket assignment.
Role-based access restrictions.
AI service integration.
Repository and database operations.
Exception handling.
Run Unit Tests
bash
mvn test

Run Complete Verification
bash
mvn clean verify


Integration tests using Testcontainers require a working Docker environment.

🔒 Security Best Practices

The application follows security best practices:

Password hashing using BCrypt.
Secure JWT-based authentication.
Role-based authorization.
Environment-based secret management.
Secure database credentials.
Request validation.
Centralized exception handling.
Protected API endpoints.
Restricted access to customer tickets.
Secure Gemini API key management.
No sensitive credentials committed to GitHub.
🏗️ Application Architecture

The project follows a layered architecture to maintain separation of concerns and improve maintainability.

text
          Client / Frontend
                 |
                 v
          REST Controllers
                 |
                 v
           Service Layer
                 |
        +--------+--------+
        |                 |
        v                 v
  Repositories       Gemini AI Service
        |
        v
    Spring Data JPA
        |
        v
      Hibernate
        |
        v
       MySQL

Main Application Layers
Controller Layer: Handles HTTP requests and responses.
Service Layer: Implements business logic.
Repository Layer: Handles database operations.
Entity Layer: Defines database entities.
DTO Layer: Manages API request and response objects.
Security Layer: Handles authentication and authorization.
AI Layer: Integrates Google Gemini AI.
Exception Layer: Handles application exceptions consistently.
📊 Project Completion Status

All planned core development modules have been implemented.

Module	Status
Spring Boot Project Setup	Completed
MySQL Configuration	Completed
Flyway Integration	Completed
User Registration	Completed
User Login	Completed
JWT Authentication	Completed
Spring Security Integration	Completed
Role-Based Access Control	Completed
User Management	Completed
Ticket CRUD Operations	Completed
Ticket Assignment	Completed
Ticket Status Management	Completed
Ticket Priority Management	Completed
Google Gemini Integration	Completed
AI Ticket Classification	Completed
AI Response Suggestions	Completed
AI Ticket Summarization	Completed
Swagger/OpenAPI Documentation	Completed
Unit Testing	Completed
Integration Testing	Completed
Docker Configuration	Completed
Docker Compose Deployment	Completed
Exception Handling	Completed
Security Configuration	Completed
🚀 Final Project Outcome

The AI-Powered Support Ticket Management System has been developed as a complete backend application for modern customer support management.

The completed application provides:

A secure authentication and authorization system.
Complete customer support ticket lifecycle management.
Role-based access for administrators, agents, and customers.
AI-powered ticket classification and assistance.
Intelligent response generation and ticket summarization.
Reliable database management with MySQL and Flyway.
Well-structured REST APIs.
Interactive API documentation.
Automated testing support.
Docker-based deployment configuration.

The application provides a scalable foundation for integrating with frontend applications, customer support portals, and external business systems.

Project Status: FULLY COMPLETED

👨‍💻 Author

Anmol Mishra

GitHub: https://github.com/anmolmishra09

Project Repository: https://github.com/anmolmishra09/ticket-ai-system

📄 License

This repository is publicly available on GitHub. Licensing and reuse permissions are governed by the license file included in the repository.

⭐ Support

If you find this project useful or interesting, consider giving the repository a star!