# HomeVote

**HomeVote** makes it easy to suggest new home items or improvements and have your housemates vote. Turn debates into
decisions—fast, fair, and fun!

## Features

* Create and update requests via REST API
* Start a voting phase for a request
* Cast votes on requests
* Data persistence using PostgreSQL and Spring Data JPA
* Automatic database migrations with Flyway on startup
* Docker Compose setup for local PostgreSQL development

## Tech Stack

* **Java 17**
* **Spring Boot 4** (WebMVC, Data JPA, Flyway)
* **PostgreSQL 16** (via Docker for local development)
* **Flyway** for database migrations
* **Maven** for build and dependency management

## Requirements

* Java 17 or higher
* Maven 3.9 or higher
* Docker (optional, recommended for local database setup)

## Quickstart

### Start PostgreSQL with Docker (recommended for local dev)

A ready-to-use Docker Compose setup is included:

```bash
cd docker
docker compose up -d
```

### Run the application

Using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or build a standalone JAR and run it:

```bash
./mvnw clean package
java -jar target/HomeVote-0.0.1-SNAPSHOT.jar
```

By default, the application is available at [http://localhost:8080](http://localhost:8080).

### Database migrations

Flyway automatically applies database migrations at application startup. Migration scripts are stored in the resources
directory and define the database schema.