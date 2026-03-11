package it.stefanopisano.homevote.request.domain;

import java.util.UUID;

public final class Vote {

    private final UUID id;
    private final UUID userID;
    private VoteChoice voteChoice;

    public Vote(UUID id, UUID userID, VoteChoice voteChoice) {
        this.id = id;
        this.userID = userID;
        this.voteChoice = voteChoice;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserID() {
        return userID;
    }

    public VoteChoice getVoteChoice() {
        return voteChoice;
    }

    public void updateChoice(VoteChoice choice) {
        this.voteChoice = choice;
    }
}
