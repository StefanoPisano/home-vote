package it.stefanopisano.homevote.request.infrastructure.persistence.jpa;

import it.stefanopisano.homevote.request.domain.Vote;
import it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity.RequestEntity;
import it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity.VoteEntity;

import java.util.List;
import java.util.stream.Collectors;

public class VoteMapper {
    static List<VoteEntity> toEntity(List<Vote> votes, RequestEntity requestEntity) {
        return votes.stream().map(vote -> toEntity(vote, requestEntity)).collect(Collectors.toList());
    }

    static VoteEntity toEntity(Vote vote, RequestEntity requestEntity) {
        return new VoteEntity(
                vote.getId(), vote.getVoteChoice(), vote.getUserID(), requestEntity
        );
    }

    static List<Vote> toDomain(List<VoteEntity> entities) {
        return entities.stream().map(VoteMapper::toDomain).collect(Collectors.toList());
    }

    static Vote toDomain(VoteEntity entity) {
        return new Vote(entity.getId(), entity.getUserId(), entity.getVoteChoice());
    }
}