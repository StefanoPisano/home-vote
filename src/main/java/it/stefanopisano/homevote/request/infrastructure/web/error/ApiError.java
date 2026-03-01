package it.stefanopisano.homevote.request.infrastructure.web.error;

import java.time.LocalDateTime;

public record ApiError(String trackingId, String code, String message, LocalDateTime timestamp) {
}
