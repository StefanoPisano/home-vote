package it.stefanopisano.homevote.request.domain;

import java.util.Optional;
import java.util.UUID;

public interface RequestRepository {
    void save(Request request);
    Optional<Request> findById(UUID id);

    void update(Request request);

    void deleteByID(UUID requestID);
}