package it.stefanopisano.homevote.request.infrastructure.persistence.jpa;

import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity.RequestEntity;

public class RequestMapper {
    static RequestEntity toEntity(Request request) {
        final RequestEntity requestEntity = new RequestEntity(
                request.getId(),
                request.getTitle(),
                request.getDescription(),
                request.getType(),
                request.getStatus(),
                request.getCreatedAt(),
                request.getReasons(),
                request.getOwnerID(),
                request.getHomeID(),
                null
        );

        requestEntity.setVotes(VoteMapper.toEntity(request.getVotes(), requestEntity));

        return requestEntity;
    }

    static Request toDomain(RequestEntity entity) {
        final Request request = new Request(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getType(),
                entity.getCreatedAt(),
                entity.getReasons(),
                entity.getOwnerID(),
                entity.getHomeID(),
                null);

        request.setVotes(VoteMapper.toDomain(entity.getVotes()));

        return request;
    }
}