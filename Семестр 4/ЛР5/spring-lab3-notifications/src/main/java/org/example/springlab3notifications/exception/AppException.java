package org.example.springlab3notifications.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public abstract class AppException extends RuntimeException {
    private final HttpStatus status;
    private final Map<String, Object> details;

    public AppException(String message, HttpStatus status, Map<String, Object> details) {
        super(message);
        this.status = status;
        this.details = details;
    }
}