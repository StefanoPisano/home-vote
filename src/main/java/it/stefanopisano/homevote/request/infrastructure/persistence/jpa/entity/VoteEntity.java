package it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity;


import it.stefanopisano.homevote.request.domain.VoteChoice;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "votes")
public class VoteEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    private VoteChoice voteChoice;
    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private RequestEntity request;


    public VoteEntity(UUID id, VoteChoice voteChoice, UUID userId, RequestEntity request) {
        this.id = id;
        this.voteChoice = voteChoice;
        this.userId = userId;
        this.request = request;
    }

    public VoteEntity() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public VoteChoice getVoteChoice() {
        return voteChoice;
    }

    public void setVoteChoice(VoteChoice voteChoice) {
        this.voteChoice = voteChoice;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public RequestEntity getRequest() {
        return request;
    }

    public void setRequest(RequestEntity request) {
        this.request = request;
    }
}