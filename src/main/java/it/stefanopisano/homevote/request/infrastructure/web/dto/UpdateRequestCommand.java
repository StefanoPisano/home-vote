package it.stefanopisano.homevote.request.infrastructure.web.dto;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record UpdateRequestCommand(UUID requestID, Optional<String> title, Optional<String> description,
                                   Optional<String> requestType, Optional<LocalDateTime> deadline) {
}
