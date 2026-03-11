package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;

import java.util.Optional;
import java.util.UUID;

public class StartVotingRequestUseCase {
    private final RequestRepository requestRepository;

    public StartVotingRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void execute(UUID requestId) {
        final Optional<Request> request = requestRepository.findById(requestId);

        request.ifPresentOrElse(r -> {
            r.startVoting();
            requestRepository.update(r);
        }, () -> {
            throw new RuntimeException("no request");
        });

    }
}