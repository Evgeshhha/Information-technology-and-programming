package org.example.springlab3notifications.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ProblemDetail handle(AppException ex) {
        ProblemDetail pd = ProblemDetail.forStatus(ex.getStatus());

        pd.setDetail(ex.getMessage());
        pd.setProperty("details", ex.getDetails());

        return pd;
    }
}