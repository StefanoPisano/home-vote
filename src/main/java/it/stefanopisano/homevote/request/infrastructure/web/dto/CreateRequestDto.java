package it.stefanopisano.homevote.request.infrastructure.web.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateRequestDto (String title,String description,String requestType,LocalDateTime deadline,UUID ownerID,UUID homeID) {}
