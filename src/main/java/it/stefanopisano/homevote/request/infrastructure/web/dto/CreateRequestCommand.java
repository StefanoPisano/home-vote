package it.stefanopisano.homevote.request.infrastructure.web.dto;

import java.util.UUID;

public record CreateRequestCommand(String title, String description, String requestType, String reasons,
                                   UUID ownerID, UUID homeID) {
}
