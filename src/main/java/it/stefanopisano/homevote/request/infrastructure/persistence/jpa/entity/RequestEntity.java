package it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity;


import it.stefanopisano.homevote.request.domain.RequestStatus;
import it.stefanopisano.homevote.request.domain.RequestType;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "requests")
public class RequestEntity {

    @Id
    private UUID id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime deadline;

    private UUID ownerID;
    private UUID homeID;

    public RequestEntity(UUID id, String title, String description, RequestType type, RequestStatus status, LocalDateTime createdAt, LocalDateTime deadline, UUID ownerID, UUID  homeID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.ownerID = ownerID;
        this.homeID = homeID;
    }

    public RequestEntity() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public UUID getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(UUID ownerID) {
        this.ownerID = ownerID;
    }

    public UUID getHomeID() {
        return homeID;
    }

    public void setHomeID(UUID homeID) {
        this.homeID = homeID;
    }

}