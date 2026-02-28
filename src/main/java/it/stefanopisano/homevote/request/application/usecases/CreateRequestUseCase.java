package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import it.stefanopisano.homevote.request.domain.RequestType;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateRequestUseCase {
    private final RequestRepository requestRepository;

    public CreateRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void execute(String title, String description, String type, LocalDateTime deadline, UUID ownerID, UUID homeId) {
        Request request = new Request(UUID.randomUUID(), title, description,
                Enum.valueOf(RequestType.class, type),
                LocalDateTime.now(), deadline, ownerID, homeId);

        requestRepository.save(request);
    }
}