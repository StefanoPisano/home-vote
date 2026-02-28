package it.stefanopisano.homevote.request.infrastructure.persistence.jpa;

import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity.RequestEntity;

public class RequestMapper {
    static RequestEntity toEntity(Request request) {
        return new RequestEntity(
                request.getId(),
                request.getTitle(),
                request.getDescription(),
                request.getType(),
                request.getStatus(),
                request.getCreatedAt(),
                request.getDeadline(),
                request.getOwnerID(),
                request.getHomeID()
        );
    }

    static Request toDomain(RequestEntity entity) {
        return new Request(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getType(),
                entity.getCreatedAt(),
                entity.getDeadline(),
                entity.getOwnerID(),
                entity.getHomeID());
    }
}