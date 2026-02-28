# HomeVote

HomeVote is a Spring Boot 4 (Java 17) application that provides APIs to create and manage requests that can be voted on within a home/community context.

This repository currently exposes a minimal REST endpoint to create requests and persists them to a PostgreSQL database via Spring Data JPA and Flyway migrations.

## Features
- Create a request via REST API
- Persist data with PostgreSQL
- Database schema managed with Flyway
- Docker Compose for a local PostgreSQL instance

## Tech Stack
- Java 17
- Spring Boot 4 (webmvc, data-jpa, flyway)
- PostgreSQL
- Flyway
- Maven
- Docker Compose (for local DB)

## Quick Start

### Start PostgreSQL with Docker
A ready-to-use docker-compose is provided.

```bash
cd docker
docker compose up -d
```

## Database Migrations
Flyway runs automatically on startup. The initial schema is defined in:
- `src/main/resources/db/migration/V1__create_requests_table.sql`

## API

### Create a Request
- Method: POST
- URL: `/api/v1/requests`
- Content-Type: `application/json`
- Body example:
```json
{
  "title": "Fix elevator",
  "description": "The elevator has intermittent issues; propose a repair.",
  "requestType": "MAINTENANCE",
  "deadline": "2026-03-31T23:59:59",
  "ownerID": "6c58f5ce-6e74-4e23-9d3e-2a4f4c6a3a11",
  "homeID": "0a78b6d8-3dfb-4a99-9a39-8e3a0a5a6b33"
}
```
- Response: `201 Created` (empty body)

Note: `requestType` should match a valid RequestType value defined in code (see `it.stefanopisano.homevote.request.domain.RequestType`).

## Project Structure (high-level)
- `src/main/java/.../HomeVoteApplication.java` – Spring Boot entry point
- `src/main/java/.../request/...` – Domain, use cases, persistence, and web layers
- `src/main/resources/application.properties` – App configuration
- `src/main/resources/db/migration` – Flyway migrations
- `docker/docker-compose.yml` – Local PostgreSQL service

## Requirements
- Java 17+
- Maven 3.9+
- Docker (optional, for local DB)

## License
This project currently does not specify a license. Add one if you plan to distribute or open-source the project.
