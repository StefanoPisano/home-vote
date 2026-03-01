package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import it.stefanopisano.homevote.request.domain.RequestType;
import it.stefanopisano.homevote.request.infrastructure.web.filter.TrackingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateRequestUseCase {

    private static final Logger log = LoggerFactory.getLogger(CreateRequestUseCase.class);

    private final RequestRepository requestRepository;

    public CreateRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void execute(String title, String description, String type, LocalDateTime deadline, UUID ownerID, UUID homeId) {
        log.info("{} || Creating request \"{}\" for homeId={}", MDC.get(TrackingFilter.TRACKING_ID), title, homeId);

        final Request request = new Request(UUID.randomUUID(), title, description, null,
                Enum.valueOf(RequestType.class, type),
                LocalDateTime.now(), deadline, ownerID, homeId);

        requestRepository.save(request);
    }
}