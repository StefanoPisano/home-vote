package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import it.stefanopisano.homevote.request.domain.RequestType;
import it.stefanopisano.homevote.request.infrastructure.web.dto.CreateRequestCommand;
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

    public void execute(CreateRequestCommand createRequestCommand) {
        log.info("{} || Creating request \"{}\" for homeId={}", MDC.get(TrackingFilter.TRACKING_ID), createRequestCommand.title(), createRequestCommand.homeID());

        final Request request = new Request(UUID.randomUUID(), createRequestCommand.title(), createRequestCommand.description(), null,
                Enum.valueOf(RequestType.class, createRequestCommand.requestType()),
                LocalDateTime.now(), createRequestCommand.reasons(), createRequestCommand.ownerID(), createRequestCommand.homeID());

        requestRepository.save(request);
    }
}