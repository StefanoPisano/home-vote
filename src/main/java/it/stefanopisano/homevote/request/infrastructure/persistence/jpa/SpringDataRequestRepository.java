package it.stefanopisano.homevote.request.infrastructure.persistence.jpa;

import it.stefanopisano.homevote.request.infrastructure.persistence.jpa.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataRequestRepository
        extends JpaRepository<RequestEntity, UUID> {
}