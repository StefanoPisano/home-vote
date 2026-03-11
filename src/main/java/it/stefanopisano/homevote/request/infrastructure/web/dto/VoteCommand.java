package it.stefanopisano.homevote.request.infrastructure.web.dto;

import it.stefanopisano.homevote.request.domain.VoteChoice;

import java.util.UUID;

public record VoteCommand(UUID requestId, VoteChoice voteChoice, UUID userId) {
}
