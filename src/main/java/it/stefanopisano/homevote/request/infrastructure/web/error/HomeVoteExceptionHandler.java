package it.stefanopisano.homevote.request.infrastructure.web.error;

import it.stefanopisano.homevote.request.application.usecases.error.RequestException;
import it.stefanopisano.homevote.request.infrastructure.web.filter.TrackingFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HomeVoteExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ApiError handleGenericError(Exception ex, HttpServletRequest request) {
        return buildApiError("INTERNAL_ERROR", ex.getMessage(), request);
    }

    @ExceptionHandler(RequestException.class)
    public ApiError handleRequestException(RequestException ex, HttpServletRequest request) {
        return buildApiError(ex.getCode(), ex.getMessage(), request);
    }

    private ApiError buildApiError(String code, String message, HttpServletRequest request) {
        final String trackingId = (String) request.getAttribute(TrackingFilter.TRACKING_ID);
        return new ApiError(trackingId, code, message, LocalDateTime.now());
    }

}
