package it.stefanopisano.homevote.request.domain;

public enum RequestStatus {
    CREATED,
    VOTING,
    IN_REVISION,
    CANCELED,
    REJECTED,
    APPROVED
}
