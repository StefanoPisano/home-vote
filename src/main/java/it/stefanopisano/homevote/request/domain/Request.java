package it.stefanopisano.homevote.request.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Request {
    private final UUID id;
    private final String title;
    private final String description;
    private final RequestType type;
    private RequestStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime deadline;
    private UUID ownerID;
    private UUID homeID;

    public Request(UUID id, String title, String description, RequestType type, LocalDateTime createdAt, LocalDateTime deadline, UUID ownerID, UUID homeID) {
        if(title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be empty");

        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = RequestStatus.PENDING;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.ownerID = ownerID;
        this.homeID = homeID;
    }

    public void approve() {
        this.status = RequestStatus.APPROVED;
    }

    public void reject() {
        this.status = RequestStatus.REJECTED;
    }

    public RequestStatus getStatus() { return status; }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public RequestType getType() {
        return type;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
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