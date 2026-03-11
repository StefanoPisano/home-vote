package it.stefanopisano.homevote.request.domain;

import java.util.Optional;

public record RequestUpdate(
        Optional<String> title,
        Optional<String> description,
        Optional<RequestType> type,
        Optional<String> reasons) {
}
