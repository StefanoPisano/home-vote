package it.stefanopisano.homevote.request.infrastructure.web;

import it.stefanopisano.homevote.request.application.usecases.CreateRequestUseCase;
import it.stefanopisano.homevote.request.application.usecases.StartVotingRequestUseCase;
import it.stefanopisano.homevote.request.application.usecases.UpdateRequestUseCase;
import it.stefanopisano.homevote.request.infrastructure.web.dto.CreateRequestCommand;
import it.stefanopisano.homevote.request.infrastructure.web.dto.UpdateRequestCommand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {

    private final CreateRequestUseCase createRequestUseCase;
    private final UpdateRequestUseCase updateRequestUseCase;
    private final StartVotingRequestUseCase startVotingRequestUseCase;

    public RequestController(CreateRequestUseCase createRequestUseCase, UpdateRequestUseCase updateRequestUseCase, StartVotingRequestUseCase startVotingRequestUseCase) {
        this.createRequestUseCase = createRequestUseCase;
        this.updateRequestUseCase = updateRequestUseCase;
        this.startVotingRequestUseCase = startVotingRequestUseCase;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody CreateRequestCommand createRequestCommand) {
        createRequestUseCase.execute(createRequestCommand);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void update(@RequestBody UpdateRequestCommand updateRequestCommand) {
        updateRequestUseCase.execute(updateRequestCommand);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{id}/start-voting")
    public void startVoting(@PathVariable UUID id) {
        startVotingRequestUseCase.execute(id);
    }
}
