package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.application.usecases.mapper.RequestUpdateMapper;
import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import it.stefanopisano.homevote.request.infrastructure.web.dto.UpdateRequestCommand;

import java.util.Optional;

public class UpdateRequestUseCase {
    private final RequestRepository requestRepository;

    public UpdateRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void execute(UpdateRequestCommand command) {
        final Optional<Request> request = requestRepository.findById(command.requestID());


        request.ifPresentOrElse(r -> {
            r.applyUpdates(RequestUpdateMapper.toRequestUpdate(command));
            requestRepository.update(r);
        }, () -> {
            throw new RuntimeException("no request");
        });

    }
}