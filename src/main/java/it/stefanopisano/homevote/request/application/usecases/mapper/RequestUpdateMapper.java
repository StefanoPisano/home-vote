package it.stefanopisano.homevote.request.application.usecases.mapper;

import it.stefanopisano.homevote.request.domain.RequestType;
import it.stefanopisano.homevote.request.domain.RequestUpdate;
import it.stefanopisano.homevote.request.infrastructure.web.dto.UpdateRequestCommand;

import java.util.Optional;

public class RequestUpdateMapper {
    public static RequestUpdate toRequestUpdate(UpdateRequestCommand command) {
        return new RequestUpdate(
                command.title(),
                command.description(),
                command.requestType().isPresent() ? Optional.of(RequestType.valueOf(RequestType.class, command.requestType().get())) : Optional.empty(),
                command.deadline()
        );
    }
}