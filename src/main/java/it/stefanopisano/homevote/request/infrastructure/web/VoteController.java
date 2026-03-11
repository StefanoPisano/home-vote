package it.stefanopisano.homevote.request.infrastructure.web;

import it.stefanopisano.homevote.request.application.usecases.VoteUseCase;
import it.stefanopisano.homevote.request.infrastructure.web.dto.VoteCommand;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {

    private final VoteUseCase voteUseCase;

    public VoteController(VoteUseCase voteUseCase) {
        this.voteUseCase = voteUseCase;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void vote(@RequestBody @Validated VoteCommand voteCommand) {
        voteUseCase.execute(voteCommand);
    }
}
