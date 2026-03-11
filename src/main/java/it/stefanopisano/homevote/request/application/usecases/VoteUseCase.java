package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.domain.Request;
import it.stefanopisano.homevote.request.domain.RequestRepository;
import it.stefanopisano.homevote.request.infrastructure.web.dto.VoteCommand;

import java.util.Optional;

public class VoteUseCase {
    private final RequestRepository requestRepository;

    public VoteUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void execute(VoteCommand command) {
        final Optional<Request> request = requestRepository.findById(command.requestId());

        request.ifPresentOrElse(r -> {
            r.vote(command.userId(), command.voteChoice());
            requestRepository.update(r);
        }, () -> {
            throw new RuntimeException("Invalid request");
        });

    }
}