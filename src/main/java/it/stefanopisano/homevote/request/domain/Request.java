package it.stefanopisano.homevote.request.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Request {
    private final UUID id;
    private String title;
    private String description;
    private RequestType type;
    private RequestStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime deadline;
    private final UUID ownerID;
    private final UUID homeID;

    public Request(UUID id, String title, String description, RequestStatus status, RequestType type, LocalDateTime createdAt, LocalDateTime deadline, UUID ownerID, UUID homeID) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title cannot be empty");

        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status == null ? RequestStatus.PENDING : status;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.ownerID = ownerID;
        this.homeID = homeID;
    }

    public void applyUpdates(RequestUpdate requestUpdate) {
        if (this.status != RequestStatus.PENDING) {
            throw new IllegalArgumentException("This request has already been processed, you can't modify it.");
        }

        if (requestUpdate.title().isPresent()) {
            this.title = requestUpdate.title().get();
        }

        if (requestUpdate.description().isPresent()) {
            this.description = requestUpdate.description().get();
        }

        if (requestUpdate.deadline().isPresent()) {
            this.deadline = requestUpdate.deadline().get();
        }

        if (requestUpdate.type().isPresent()) {
            this.type = requestUpdate.type().get();
        }
    }

    public void approve() {
        this.status = RequestStatus.APPROVED;
    }

    public void reject() {
        this.status = RequestStatus.REJECTED;
    }

    public RequestStatus getStatus() {
        return status;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public UUID getOwnerID() {
        return ownerID;
    }

    public UUID getHomeID() {
        return homeID;
    }
}