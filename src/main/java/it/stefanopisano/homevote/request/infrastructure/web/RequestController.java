package it.stefanopisano.homevote.request.infrastructure.web;

import it.stefanopisano.homevote.request.application.usecases.CreateRequestUseCase;
import it.stefanopisano.homevote.request.infrastructure.web.dto.CreateRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {

    private final CreateRequestUseCase createRequestUseCase;

    public RequestController(CreateRequestUseCase createRequestUseCase) {
        this.createRequestUseCase = createRequestUseCase;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody CreateRequestDto createRequestDto) {
        createRequestUseCase.execute(createRequestDto.title(), createRequestDto.description(), createRequestDto.requestType(), createRequestDto.deadline(), createRequestDto.ownerID(), createRequestDto.homeID());
    }
}
