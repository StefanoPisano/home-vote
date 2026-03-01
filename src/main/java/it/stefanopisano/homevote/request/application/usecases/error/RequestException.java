package it.stefanopisano.homevote.request.application.usecases.error;

public class RequestException extends RuntimeException {

    private final String code;

    public RequestException(String code, String message) {
        super(message);

        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
