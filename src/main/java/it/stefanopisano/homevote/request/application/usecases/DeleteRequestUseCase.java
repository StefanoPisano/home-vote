package it.stefanopisano.homevote.request.application.usecases;


import it.stefanopisano.homevote.request.domain.RequestRepository;

import java.util.UUID;

public class DeleteRequestUseCase {
    private final RequestRepository requestRepository;

    public DeleteRequestUseCase(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void execute(UUID requestID) {
        requestRepository.deleteByID(requestID);
    }
}