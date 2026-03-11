package it.stefanopisano.homevote.request.domain;

import it.stefanopisano.homevote.request.application.usecases.error.RequestException;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Request {
    private final UUID id;
    private String title;
    private String description;
    private RequestType type;
    private RequestStatus status;
    private final LocalDateTime createdAt;
    private String reasons;
    private final UUID ownerID;
    private final UUID homeID;
    private List<Vote> votes;

    public Request(UUID id, String title, String description, RequestStatus status, RequestType type, LocalDateTime createdAt, String reasons, UUID ownerID, UUID homeID, List<Vote> votes) {
        this.validate(title, description, type, reasons, homeID, ownerID);

        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = status == null ? RequestStatus.CREATED : status;
        this.createdAt = createdAt;
        this.reasons = reasons;
        this.ownerID = ownerID;
        this.homeID = homeID;
        this.votes = new ArrayList<>();
    }

    private void validate(String title, String description, RequestType type, String reasons, UUID homeID, UUID ownerID) {
        if (title == null || title.isBlank()) {
            throw new RequestException("NO_TITLE", "Request title must be not empty.");
        }

        if (description == null || description.isBlank()) {
            throw new RequestException("NO_DESCRIPTION", "Request description must be not empty.");
        }

        if (type == null) {
            throw new RequestException("NO_DESCRIPTION", "Request description must be not empty.");
        }

        if (reasons == null || reasons.isBlank()) {
            throw new RequestException("NO_REASONS", "Request reasons must be not empty.");
        }

        if (homeID == null) {
            throw new RequestException("NO_HOME", "Request must be associated with a valid home.");
        }

        if (ownerID == null) {
            throw new RequestException("NO_OWNER", "Request must be associated to a owner.");
        }

    }

    public void vote(UUID userID, VoteChoice choice) {
        Assert.notNull(choice, "Vote Must be not null");

        if (this.status != RequestStatus.VOTING) {
            throw new RequestException("NOT_VOTING", "Request is not accepting new votes.");
        }

        if (hasAlreadyVoted(userID)) {
            updateVote(userID, choice);
        } else {
            votes.add(new Vote(null, userID, choice));
        }
    }

    private void updateVote(UUID userID, VoteChoice choice) {
        final Optional<Vote> toBeUpdated = votes.stream()
                .filter(vote -> vote.getUserID().equals(userID))
                .findFirst();

        if (toBeUpdated.isEmpty()) {
            throw new RequestException("NOT_FOUND", "Vote not found.");
        } else {
            toBeUpdated.get().updateChoice(choice);
        }
    }

    private boolean hasAlreadyVoted(UUID userID) {
        return votes.stream()
                .anyMatch(vote -> vote.getUserID().equals(userID));
    }

    public void applyUpdates(RequestUpdate requestUpdate) {
        if (!canBeUpdated()) {
            throw new RequestException("ALREADY_PROCESSED", "This request has already been processed.");
        }

        if (requestUpdate.title().isPresent()) {
            this.title = requestUpdate.title().get();
        }

        if (requestUpdate.description().isPresent()) {
            this.description = requestUpdate.description().get();
        }

        if (requestUpdate.reasons().isPresent()) {
            this.reasons = requestUpdate.reasons().get();
        }

        if (requestUpdate.type().isPresent()) {
            this.type = requestUpdate.type().get();
        }
    }

    public void startVoting() {
        if (!canBeUpdated()) {
            throw new RequestException("ALREADY_PROCESSED", "This request has already been processed.");
        }

        this.status = RequestStatus.VOTING;
    }

    public void cancel() {
        if (!canBeUpdated()) {
            throw new RequestException("ALREADY_PROCESSED", "This request has already been processed.");
        }

        this.status = RequestStatus.CANCELED;
    }

    public void approve() {
        if (this.status != RequestStatus.VOTING) {
            throw new RequestException("NO_VOTES", "Can't approve a request without voting it first.");
        }

        this.status = RequestStatus.APPROVED;
    }

    public void reject() {
        if (!canBeUpdated()) {
            throw new RequestException("ALREADY_PROCESSED", "This request has already been processed.");
        }

        this.status = RequestStatus.REJECTED;
    }

    private boolean canBeUpdated() {
        return this.status == RequestStatus.CREATED || this.status == RequestStatus.IN_REVISION;
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

    public String getReasons() {
        return reasons;
    }

    public UUID getOwnerID() {
        return ownerID;
    }

    public UUID getHomeID() {
        return homeID;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}